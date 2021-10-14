package com.climbtogether.climby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {

}
