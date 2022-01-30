package com.haniyemollaei.mosallas.controller;

import com.haniyemollaei.mosallas.domain.Category;
import com.haniyemollaei.mosallas.domain.Province;
import com.haniyemollaei.mosallas.domain.User;
import com.haniyemollaei.mosallas.repository.CategoryRepository;
import com.haniyemollaei.mosallas.repository.ProvinceRepository;
import com.haniyemollaei.mosallas.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/")
    public List<Category> list() {
        return categoryRepository.findAll();
    }


}
