package com.climbtogether.climby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.climbtogether.climby.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {

}
