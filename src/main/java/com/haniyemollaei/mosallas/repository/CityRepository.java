package com.haniyemollaei.mosallas.repository;

import com.haniyemollaei.mosallas.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "city")
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findById(@Param("id") String id);
    List<City> findByProvinceId(@Param("provinceId") String id);

}