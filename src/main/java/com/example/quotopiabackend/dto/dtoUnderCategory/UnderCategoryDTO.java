package com.example.quotopiabackend.dto.dtoUnderCategory;

import dat3.server_to_server.dto.dtoCategory.CategoryDTO;
import jakarta.persistence.*;

public record UnderCategoryDTO(int underCategoryId, String underCategoryName, CategoryDTO categoryDTO ) {

}
