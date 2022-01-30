package com.haniyemollaei.mosallas.controller;

import com.haniyemollaei.mosallas.domain.City;
import com.haniyemollaei.mosallas.domain.Province;
import com.haniyemollaei.mosallas.domain.User;
import com.haniyemollaei.mosallas.repository.CityRepository;
import com.haniyemollaei.mosallas.repository.ProvinceRepository;
import com.haniyemollaei.mosallas.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "city")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @GetMapping("/")
    public List<City> list() {
        return cityRepository.findAll();
    }


}
