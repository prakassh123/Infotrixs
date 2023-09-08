package com.chat.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chat.app.models.Message;

@Controller
public class StompMessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private final MessageService messageService;

    public StompMessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/message")
    public void handleChatMessage(Message message) {
        // Save the message to the database
        messageService.saveMessage(message);

        // Broadcast the message to all subscribers
        messagingTemplate.convertAndSend("/topic/return-to", message);
    }
}
