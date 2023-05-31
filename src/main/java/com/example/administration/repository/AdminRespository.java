package com.example.administration.repository;

import com.example.administration.entity.Administration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRespository  extends JpaRepository<Administration, Long> {
}
