package com.whatsapp.springbootwhatsapp.Controller;

import com.whatsapp.springbootwhatsapp.Entity.Emoji;
import com.whatsapp.springbootwhatsapp.Entity.Message;
import com.whatsapp.springbootwhatsapp.Service.EmojiService;
import com.whatsapp.springbootwhatsapp.Service.MessageService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/messages"})
public class EmojiController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private EmojiService emojiService;

    public EmojiController() {
    }

    @PostMapping({"/{messageId}/emoji"})
    public ResponseEntity<String> reactToMessageWithEmoji(@PathVariable Long messageId, @RequestParam String emojiType) {
        if (!this.isValidEmojiType(emojiType)) {
            return ResponseEntity.badRequest().body("Invalid emoji type");
        } else {
            Optional<Message> optionalMessage = Optional.ofNullable(this.messageService.getMessageById(messageId));
            if (!optionalMessage.isPresent()) {
                return ResponseEntity.notFound().build();
            } else {
                Message message = (Message)optionalMessage.get();
                Emoji messageEmoji = new Emoji();
                messageEmoji.setMessage(message);
                messageEmoji.setEmojiType(emojiType);
                this.emojiService.saveMessageEmoji(messageEmoji);
                return ResponseEntity.ok("Emoji reaction added successfully");
            }
        }
    }

    private boolean isValidEmojiType(String emojiType) {
        List<String> validEmojiTypes = Arrays.asList("thumbup", "love", "crying", "surprised");
        return validEmojiTypes.contains(emojiType);
    }
}

