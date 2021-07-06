package com.offapp.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.offapp.webapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
