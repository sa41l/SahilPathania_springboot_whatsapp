package com.whatsapp.springbootwhatsapp.DTO;

import org.springframework.web.multipart.MultipartFile;

public class MessageRequestDTO {
    private Long chatroomId;
    private String text;
    private MultipartFile attachment;

    public MessageRequestDTO() {
    }

    public Long getChatroomId() {
        return this.chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile getAttachment() {
        return this.attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }
}
