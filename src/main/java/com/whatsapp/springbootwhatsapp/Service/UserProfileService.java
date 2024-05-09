package com.whatsapp.springbootwhatsapp.Service;

import com.whatsapp.springbootwhatsapp.Entity.UserProfile;
import com.whatsapp.springbootwhatsapp.Repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserProfileService {
    private final UserRepository userRepository;

    @Autowired
    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfile createUserProfile(UserProfile userProfile) {
        return (UserProfile)this.userRepository.save(userProfile);
    }

    public Optional<UserProfile> getUserProfile(Long userId) {
        return this.userRepository.findById(userId);
    }

    public UserProfile getUserById(Long userId) {
        return (UserProfile)this.userRepository.findById(userId).orElseThrow(() -> {
            return new RuntimeException("User not found");
        });
    }

    public void updateUserProfile(Long userId, UserProfile userProfile) {
        Optional<UserProfile> existingProfile = this.userRepository.findById(userId);
        if (existingProfile.isPresent()) {
            UserProfile existing = (UserProfile)existingProfile.get();
            existing.setUsername(userProfile.getUsername());
            existing.setEmail(userProfile.getEmail());
            existing.setAvatarUrl(userProfile.getAvatarUrl());
            existing.setBio(userProfile.getBio());
            this.userRepository.save(existing);
        }

    }
}
