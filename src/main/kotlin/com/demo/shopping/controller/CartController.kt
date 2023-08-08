package com.demo.shopping.controller

import com.demo.shopping.DTO.CartDTO
import com.demo.shopping.services.CartService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CartController(
    private val cartService: CartService
) {
    @PostMapping("/add-to-cart", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addToCart(@RequestBody cart:CartDTO) {
        cartService.addToCart(cart)
    }

}