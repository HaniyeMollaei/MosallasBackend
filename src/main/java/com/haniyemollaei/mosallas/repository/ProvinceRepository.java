package com.haniyemollaei.mosallas.repository;

import com.haniyemollaei.mosallas.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "province")
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    List<Province> findById(@Param("id") String id);

}