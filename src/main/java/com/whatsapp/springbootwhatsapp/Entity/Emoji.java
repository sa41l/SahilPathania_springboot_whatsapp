package com.whatsapp.springbootwhatsapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "message_emoji"
)
public class Emoji {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "message_id",
            referencedColumnName = "id"
    )
    private Message message;
    @Column(
            nullable = false
    )
    private String emojiType;

    public Emoji() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message getMessage() {
        return this.message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getEmojiType() {
        return this.emojiType;
    }

    public void setEmojiType(String emojiType) {
        this.emojiType = emojiType;
    }
}
