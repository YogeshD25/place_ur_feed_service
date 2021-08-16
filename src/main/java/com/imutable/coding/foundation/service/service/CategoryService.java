package com.imutable.coding.foundation.service.service;


import com.imutable.coding.foundation.service.model.Category;
import com.imutable.coding.foundation.service.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory(Category category){
        log.info("Inside Place Service for Saving place");
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        log.info("Inside Place Service for getting all places");
        return categoryRepository.findAll();
    }
}
