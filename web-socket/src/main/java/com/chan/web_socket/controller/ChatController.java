package com.chan.web_socket.controller;

import com.chan.web_socket.dto.ChatMessage;
import com.chan.web_socket.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // 클라이언트 -> 서버: /app/chat.sendMessage
    // 서버 -> 클라이언트: /topic/public
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        return chatService.processMessage(message);
    }

    // 클라이언트 -> 서버: /app/chat.addUser
    // 서버 -> 클라이언트: /topic/public
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message) {
        return chatService.processMessage(message);
    }
}
