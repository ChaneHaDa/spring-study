package com.chan.web_socket.controller;

import com.chan.web_socket.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.JOIN.equals(message.getType())) {
            message.setContent(message.getSender() + "님이 입장하셨습니다.");
        }
        messagingTemplate.convertAndSend("/topic/room/" + message.getRoomId(), message);
    }
}
