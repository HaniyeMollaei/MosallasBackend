package com.haniyemollaei.mosallas.repository;

import com.haniyemollaei.mosallas.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findById(@Param("id") String id);

}
