package com.chan.web_socket.service;

import com.chan.web_socket.dto.ChatMessage;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public ChatMessage processMessage(ChatMessage message) {
        // 여기서 메시지 타입에 따른 추가적인 비즈니스 로직을 처리할 수 있습니다.
        // 예를 들어, JOIN 메시지일 경우 환영 메시지를 설정하거나,
        // 데이터베이스에 채팅 내용을 저장하는 로직을 추가할 수 있습니다.
        if (ChatMessage.MessageType.JOIN.equals(message.getType())) {
            message.setContent(message.getSender() + "님이 입장하셨습니다.");
        }
        return message;
    }
}
