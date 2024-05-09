package com.whatsapp.springbootwhatsapp.Service;

import com.whatsapp.springbootwhatsapp.Entity.Emoji;
import com.whatsapp.springbootwhatsapp.Entity.Message;
import com.whatsapp.springbootwhatsapp.Repository.EmojiRepository;
import com.whatsapp.springbootwhatsapp.Repository.MessageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmojiService {
    @Autowired
    private EmojiRepository emojiRepository;
    @Autowired
    private MessageRepository messageRepository;

    public EmojiService() {
    }

    public Optional<Message> getMessageById(Long messageId) {
        return this.messageRepository.findById(messageId);
    }

    public void saveMessageEmoji(Emoji messageEmoji) {
        this.emojiRepository.save(messageEmoji);
    }
}
