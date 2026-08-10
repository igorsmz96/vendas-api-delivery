package com.vendas.api.delivery_api.services;

import com.vendas.api.delivery_api.controllers.request.CategoryRequest;
import com.vendas.api.delivery_api.controllers.response.CategoryResponse;
import com.vendas.api.delivery_api.entities.Category;
import com.vendas.api.delivery_api.exception.UserNotFoundException;
import com.vendas.api.delivery_api.mapper.CategoryMapper;
import com.vendas.api.delivery_api.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryResponse createCategory (CategoryRequest categoryRequest){

        Category category = categoryMapper.toCategory(categoryRequest);

        categoryRepository.save(category);
        return categoryMapper.toResponse(category);

    }

    public List<CategoryResponse> findAllCategories(){
        List <Category> categories = categoryRepository.findAll();

   return categories.stream().map(f-> categoryMapper.toResponse(f)).toList();
    }

    public CategoryResponse findCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return categoryMapper.toResponse(category);

    }

    public CategoryResponse updatePartialCategory(Long id, CategoryRequest categoryRequest){
        Category category = categoryRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        Optional.ofNullable(categoryRequest.name()).ifPresent(category::setName);
        Optional.ofNullable(categoryRequest.description()).ifPresent(category::setDescription);
        categoryRepository.save(category);
        return categoryMapper.toResponse(category);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        categoryRepository.delete(category);

    }


}
