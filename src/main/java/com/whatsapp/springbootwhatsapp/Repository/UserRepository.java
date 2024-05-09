package com.whatsapp.springbootwhatsapp.Repository;


import com.whatsapp.springbootwhatsapp.Entity.UserProfile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<UserProfile, Long> {
}