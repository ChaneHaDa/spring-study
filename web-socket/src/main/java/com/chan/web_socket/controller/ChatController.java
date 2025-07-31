package com.chan.web_socket.controller;

import com.chan.web_socket.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message, StompHeaderAccessor headerAccessor) {
        if (ChatMessage.MessageType.JOIN.equals(message.getType())) {
            Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", message.getSender());
            Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("roomId", message.getRoomId());
            message.setContent(message.getSender() + "님이 입장하셨습니다.");
        }
        messagingTemplate.convertAndSend("/topic/room/" + message.getRoomId(), message);
    }
}
