package com.whatsapp.springbootwhatsapp.Repository;

import com.whatsapp.springbootwhatsapp.Entity.Emoji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmojiRepository extends JpaRepository<Emoji, Long> {
}