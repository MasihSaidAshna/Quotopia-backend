package com.example.quotopiabackend.jwtsecurity.controller;

import com.example.quotopiabackend.jwtsecurity.JwtTokenManager;
import com.example.quotopiabackend.jwtsecurity.model.JwtRequestModel;
import com.example.quotopiabackend.jwtsecurity.model.JwtResponseModel;
import com.example.quotopiabackend.jwtsecurity.model.User;
import com.example.quotopiabackend.jwtsecurity.service.IUserService;
import com.example.quotopiabackend.jwtsecurity.service.JwtUserDetailsService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@CrossOrigin
@NoArgsConstructor
@RestController
@AllArgsConstructor
public class JwtController {

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenManager jwtTokenManager;
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<Set<User>> getAllUsers() {
        Set<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }


    @PostMapping("/signup")
    public ResponseEntity<JwtResponseModel> signup(@RequestBody JwtRequestModel request) {
        System.out.println("Signup: username:" + request.getUsername() + " password: " + request.getPassword());
        User user = new User(request.getUsername(), request.getPassword());
        if (userService.findByName(user.getUsername()) == null) {
            if (userService.save(user) != null) {
                return ResponseEntity.ok(new JwtResponseModel("created user: " + user.getUsername() + " pw: " + user.getUserPassword()));
            } else {
                return ResponseEntity.ok(new JwtResponseModel("error creating user: " + user.getUsername()));
            }
        } else {
            return ResponseEntity.ok(new JwtResponseModel("error: user exists: " + user.getUsername()));
        }
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request, HttpServletResponse response) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Assuming successful login, create a session ID
            String sessionId = UUID.randomUUID().toString();

            // Set the session cookie
            Cookie cookie = new Cookie("SESSION_ID", sessionId);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600); // Cookie expiration time in seconds (adjust as needed)
            response.addCookie(cookie);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            final String jwtToken = jwtTokenManager.generateJwtToken(userDetails);

            return ResponseEntity.ok(new JwtResponseModel(jwtToken));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("SESSION_ID", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        Map<String, String> map = new HashMap<>();
        map.put("message", "Logout successful");
        return ResponseEntity.ok(map);
    }

    @PostMapping("/getSecret")
    public ResponseEntity<Map> getSecret() {
        System.out.println("getSecret is called");
        Map<String, String> map = new HashMap<>();
        map.put("message", "this is secret from server");
        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Map> deleteUser(@RequestBody User user) { // hvis man kommer hertil, er token OK
        System.out.println("deleteUser is called with user: " + user.getUsername());
        User userToDelete = userService.findByName(user.getUsername());
        userService.delete(userToDelete);
        Map<String, String> map = new HashMap<>();
        map.put("message", "user deleted, if found " + user.getUsername());
        return ResponseEntity.ok(map);
    }
}
