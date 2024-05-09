package com.whatsapp.springbootwhatsapp.Service;

import com.whatsapp.springbootwhatsapp.Entity.Chatroom;
import com.whatsapp.springbootwhatsapp.Repository.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChatroomService {
    private final ChatroomRepository chatroomRepository;

    @Autowired
    public ChatroomService(ChatroomRepository chatroomRepository) {
        this.chatroomRepository = chatroomRepository;
    }

    public Page<Chatroom> getAllChatrooms(Pageable pageable) {
        return this.chatroomRepository.findAll(pageable);
    }

    public Chatroom createChatroom(Chatroom chatroom) {
        return (Chatroom)this.chatroomRepository.save(chatroom);
    }

    public Chatroom getChatroomById(Long id) {
        return (Chatroom)this.chatroomRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Chatroom not found with id " + id);
        });
    }
}
