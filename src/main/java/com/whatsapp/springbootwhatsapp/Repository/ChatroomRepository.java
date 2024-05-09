package com.whatsapp.springbootwhatsapp.Repository;

import com.whatsapp.springbootwhatsapp.Entity.Chatroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatroomRepository extends JpaRepository<Chatroom, Long> {
    Page<Chatroom> findAll(Pageable pageable);
}
