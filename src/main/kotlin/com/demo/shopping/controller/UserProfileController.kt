package com.demo.shopping.controller

import com.demo.shopping.beans.UserProfile
import com.demo.shopping.services.UserProfileService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserProfileController(

    private val userProfileService: UserProfileService,
) {
    @PostMapping("/add-user")
    fun addUser(@RequestBody user:UserProfile) {
        userProfileService.addUser(user)
    }
}