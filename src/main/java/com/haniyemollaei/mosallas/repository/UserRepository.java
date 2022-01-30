package com.haniyemollaei.mosallas.repository;

import com.haniyemollaei.mosallas.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User , Long> {

    List<User> findById(@Param("id") String id);

    List<User> findByMobileNo(@Param("mobileNo") String mobileNo);
}
