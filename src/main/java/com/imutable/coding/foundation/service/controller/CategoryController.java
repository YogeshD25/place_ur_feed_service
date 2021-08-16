package com.imutable.coding.foundation.service.controller;



import com.imutable.coding.foundation.service.model.Category;
import com.imutable.coding.foundation.service.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> getAllPlace() {
        log.info("Inside Category Controller in getAllCategories");
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public void savePlace(@RequestBody Category category) {
        log.info("Inside Category Controller in saveCategory");
        categoryService.saveCategory(category);
    }


}
