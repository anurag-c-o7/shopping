package com.demo.shopping.repository

import com.demo.shopping.beans.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository : JpaRepository<UserProfile,Long>{
}