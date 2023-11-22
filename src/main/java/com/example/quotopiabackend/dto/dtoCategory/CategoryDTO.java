package com.example.quotopiabackend.dto.dtoCategory;


import dat3.server_to_server.dto.dtoUnderCategory.UnderCategoryDTO;
import jakarta.persistence.*;

import java.util.List;

public record CategoryDTO(int categoryId, String categoryName, List<UnderCategoryDTO>underCategoryDTOList) {


}
