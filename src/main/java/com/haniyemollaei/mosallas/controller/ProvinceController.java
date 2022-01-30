package com.haniyemollaei.mosallas.controller;

import com.haniyemollaei.mosallas.domain.Province;
import com.haniyemollaei.mosallas.domain.User;
import com.haniyemollaei.mosallas.repository.ProvinceRepository;
import com.haniyemollaei.mosallas.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "province")
public class ProvinceController {
    private final ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }


    @GetMapping("/")
    public List<Province> list() {
        return provinceRepository.findAll();
    }


}
