package com.demo.shopping.services

import com.demo.shopping.beans.Cart
import com.demo.shopping.beans.UserProfile
import com.demo.shopping.repository.UserProfileRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class UserProfileService(
    val userProfileRepository: UserProfileRepository)
{
    fun addUser(userProfile: UserProfile) {
        val newUser:UserProfile = UserProfile(
            userName = userProfile.userName,
            email = userProfile.email,
            cart= Cart()
        )
        userProfileRepository.save(newUser)
    }
}