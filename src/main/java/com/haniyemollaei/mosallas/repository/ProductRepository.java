package com.haniyemollaei.mosallas.repository;


import com.haniyemollaei.mosallas.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "product")
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findById(@Param("id") String id);

}
