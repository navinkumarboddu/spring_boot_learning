package com.in28minutes.springboot.web.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.springboot.web.model.User;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
	List<User> findByRole(@Param("role") String role);
}