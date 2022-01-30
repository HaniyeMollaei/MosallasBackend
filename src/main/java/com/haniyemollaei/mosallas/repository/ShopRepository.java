package com.haniyemollaei.mosallas.repository;

import com.haniyemollaei.mosallas.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "shop")
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findById(@Param("id") String id);

    List<Shop> findByUserId(@Param("userId") Long userId);
}
