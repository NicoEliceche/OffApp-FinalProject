package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
