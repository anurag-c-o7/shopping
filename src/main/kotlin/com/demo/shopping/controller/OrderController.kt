package com.demo.shopping.controller

import com.demo.shopping.DTO.CartDTO
import com.demo.shopping.services.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService
) {
    @PostMapping("/place-order")
    fun placeOrder(@RequestBody cart:CartDTO) {
        orderService.placeOrder(cart)
    }
}