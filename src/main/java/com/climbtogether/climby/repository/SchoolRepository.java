package com.climbtogether.climby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, String> {

}
