package com.climbtogether.climby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
