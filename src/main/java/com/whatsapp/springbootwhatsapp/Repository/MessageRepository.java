package com.whatsapp.springbootwhatsapp.Repository;

import com.whatsapp.springbootwhatsapp.Entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByChatroomId(Long chatroomId, Pageable pageable);
}
