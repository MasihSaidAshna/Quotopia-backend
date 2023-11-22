package com.example.quotopiabackend.dto.dtoCategory;


import com.example.quotopiabackend.dto.dtoUnderCategory.UnderCategoryDTO;
import jakarta.persistence.*;

import java.util.List;

public record CategoryDTO(int categoryId, String categoryName, List<UnderCategoryDTO>underCategoryDTOList) {


}
