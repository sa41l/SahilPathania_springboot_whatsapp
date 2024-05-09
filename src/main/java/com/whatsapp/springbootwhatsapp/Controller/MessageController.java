package com.whatsapp.springbootwhatsapp.Controller;

import com.whatsapp.springbootwhatsapp.DTO.MessageRequestDTO;
import com.whatsapp.springbootwhatsapp.Entity.Message;
import com.whatsapp.springbootwhatsapp.Service.MessageService;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/messages"})
public class MessageController {
    @Autowired
    private MessageService messageService;
    Logger logger = LoggerFactory.getLogger(MessageController.class);

    public MessageController() {
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody MessageRequestDTO request) {
        try {
            Message message = this.messageService.sendMessage(request);
            return ResponseEntity.ok(message);
        } catch (IOException var3) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving attachment");
        } catch (IllegalArgumentException var4) {
            return ResponseEntity.badRequest().body(var4.getMessage());
        }
    }

    @GetMapping({"/{chatroomId}"})
    public ResponseEntity<?> getMessages(@PathVariable Long chatroomId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        try {
            Page<Message> messages = this.messageService.getMessages(chatroomId, page, size);
            return ResponseEntity.ok(messages);
        } catch (Exception var5) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving messages");
        }
    }
}
