package com.chat.app.controllers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.app.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // You can define custom query methods here if needed


}


