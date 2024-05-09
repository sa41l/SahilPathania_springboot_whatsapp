package com.whatsapp.springbootwhatsapp.Controller;

import com.whatsapp.springbootwhatsapp.Entity.Chatroom;
import com.whatsapp.springbootwhatsapp.Service.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/chatrooms"})
public class ChatroomController {
    private final ChatroomService chatroomService;

    @Autowired
    public ChatroomController(ChatroomService chatroomService) {
        this.chatroomService = chatroomService;
    }

    @GetMapping
    public ResponseEntity<Page<Chatroom>> getAllChatrooms(Pageable pageable) {
        Page<Chatroom> chatrooms = this.chatroomService.getAllChatrooms(pageable);
        return ResponseEntity.ok(chatrooms);
    }

    @PostMapping
    public ResponseEntity<Chatroom> createChatroom(@RequestBody Chatroom chatroom) {
        Chatroom createdChatroom = this.chatroomService.createChatroom(chatroom);
        return new ResponseEntity(createdChatroom, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Chatroom> getChatroomById(@PathVariable Long id) {
        Chatroom chatroom = this.chatroomService.getChatroomById(id);
        return ResponseEntity.ok(chatroom);
    }
}

