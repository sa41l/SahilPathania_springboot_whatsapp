package com.whatsapp.springbootwhatsapp.Controller;

import com.whatsapp.springbootwhatsapp.Entity.UserProfile;
import com.whatsapp.springbootwhatsapp.Service.UserProfileService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/profile"})
public class UserProfileController {
    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return this.userProfileService.createUserProfile(userProfile);
    }

    @GetMapping({"/{userId}"})
    public UserProfile getUserProfile(@PathVariable Long userId) {
        Optional<UserProfile> userProfile = this.userProfileService.getUserProfile(userId);
        return (UserProfile)userProfile.get();
    }

    @PutMapping({"/{userId}"})
    public void updateUserProfile(@PathVariable Long userId, @RequestBody UserProfile userProfile) {
        this.userProfileService.updateUserProfile(userId, userProfile);
    }
}
