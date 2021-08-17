package com.imutable.coding.foundation.service.controller;



import com.imutable.coding.foundation.service.model.Category;
import com.imutable.coding.foundation.service.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public Flux<Category> getAllPlace() {
        log.info("Inside Category Controller in getAllCategories");
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Mono<Category> savePlace(@RequestBody Category category) {
        log.info("Inside Category Controller in saveCategory");
        return categoryService.saveCategory(category);
    }


}
