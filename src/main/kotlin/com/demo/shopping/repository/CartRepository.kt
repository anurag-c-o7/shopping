package com.demo.shopping.repository

import com.demo.shopping.beans.Cart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.Optional

interface CartRepository : JpaRepository<Cart,Long>{

    @Query(value = "SELECT * FROM cart  as c " +
            "INNER JOIN user_profile uf " +
            "ON uf.cart_id = c.cart_id "+
            "WHERE user_id=:userId", nativeQuery = true)
    fun findCartByUserId(@Param("userId") userId:Long):Cart?
}