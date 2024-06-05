package com.azet.KitchenAssistant.controller;

import com.azet.KitchenAssistant.Entity.Category;
import com.azet.KitchenAssistant.dao.CategoryRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);
    CategoryRepository categoryRepository;

    CategoryController(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Category>> readCategories(){
        logger.info("all categories on one page");
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Category> addNewCategory(@RequestBody @Valid Category newCategory){

        Category result = categoryRepository.save(newCategory);
        logger.info("saved new category");

        return ResponseEntity.created(URI.create("/"+result.getId())).body(newCategory);
    }
}
