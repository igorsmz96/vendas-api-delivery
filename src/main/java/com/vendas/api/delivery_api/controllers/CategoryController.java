package com.vendas.api.delivery_api.controllers;


import com.vendas.api.delivery_api.controllers.requestCreate.CategoryRequest;
import com.vendas.api.delivery_api.controllers.requestPatch.CategoryPatchRequest;
import com.vendas.api.delivery_api.controllers.response.CategoryResponse;
import com.vendas.api.delivery_api.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory (@Valid @RequestBody CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        List <CategoryResponse> categoryResponse = categoryService.findAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);

    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long id){
        CategoryResponse categoryResponse = categoryService.findCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponse> updatePartialCategory(@PathVariable Long id, @Valid @RequestBody CategoryPatchRequest categoryPatchRequest){
        CategoryResponse categoryResponse = categoryService.updatePartialCategory(id,categoryPatchRequest);
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> deleteCategoryById(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
