package com.vendas.api.delivery_api.mapper;

import com.vendas.api.delivery_api.controllers.request.CategoryRequest;
import com.vendas.api.delivery_api.controllers.response.CategoryResponse;
import com.vendas.api.delivery_api.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryMapper {

    public Category toCategory(CategoryRequest categoryRequest) {

        Category category = new Category();
        category.setName(categoryRequest.name());
        category.setDescription(categoryRequest.description());
        return category;

    }

    public CategoryResponse toResponse (Category category) {
        return new CategoryResponse(category.getId(),category.getName()
        );

    }

}
