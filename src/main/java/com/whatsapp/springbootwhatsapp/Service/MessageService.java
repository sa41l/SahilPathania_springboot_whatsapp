package com.whatsapp.springbootwhatsapp.Service;

import com.whatsapp.springbootwhatsapp.DTO.MessageRequestDTO;
import com.whatsapp.springbootwhatsapp.Entity.Chatroom;
import com.whatsapp.springbootwhatsapp.Entity.Message;
import com.whatsapp.springbootwhatsapp.Repository.ChatroomRepository;
import com.whatsapp.springbootwhatsapp.Repository.MessageRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatroomRepository chatroomRepository;
    @Value("${attachment.upload.directory}")
    private String attachmentUploadDirectory;

    /*public MessageService() {
    }*/

    public Message getMessageById(Long messageId) {
        return (Message)this.messageRepository.findById(messageId).get();
    }

    public Page<Message> getMessages(Long chatroomId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.messageRepository.findByChatroomId(chatroomId, pageable);
    }

    public Message sendMessage(MessageRequestDTO request) throws IOException {
        Message message = new Message();
        message.setText(request.getText());
        Chatroom chatroom = (Chatroom)this.chatroomRepository.findById(request.getChatroomId()).orElseThrow(() -> {
            return new IllegalArgumentException("Chatroom not found");
        });
        message.setChatroom(chatroom);
        if (request.getAttachment() != null && request.getAttachment().getSize() > 10485760L) {
            throw new IllegalArgumentException("Attachment size exceeds the limit of 10MB");
        } else {
            if (request.getAttachment() != null) {
                String filePath = this.saveAttachment(request.getAttachment());
                message.setAttachment(filePath.getBytes());
            }

            return (Message)this.messageRepository.save(message);
        }
    }

    private String saveAttachment(MultipartFile attachment) throws IOException {
        String var10000 = UUID.randomUUID().toString();
        String fileName = var10000 + "_" + attachment.getOriginalFilename();
        Path filePath = Paths.get(this.attachmentUploadDirectory, fileName);
        Files.createDirectories(filePath.getParent());
        attachment.transferTo(filePath);
        return filePath.toString();
    }
}
