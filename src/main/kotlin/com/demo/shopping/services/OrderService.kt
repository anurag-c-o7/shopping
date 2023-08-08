package com.demo.shopping.services

import com.demo.shopping.DTO.CartDTO
import com.demo.shopping.DTO.OrderDTO
import com.demo.shopping.beans.Cart
import com.demo.shopping.beans.Order
import com.demo.shopping.beans.Product
import com.demo.shopping.beans.UserProfile
import com.demo.shopping.repository.CartRepository
import com.demo.shopping.repository.OrderRepository
import com.demo.shopping.repository.UserProfileRepository
import com.demo.shopping.utility.OrderStatusEnum
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class OrderService(
    val orderRepository: OrderRepository,
    val cartRepository: CartRepository,
    val userRepository: UserProfileRepository
) {
    fun placeOrder(cart:CartDTO) {
        //if(cart.userId == null) return
        val user: Optional<UserProfile> = userRepository.findById(cart.userId)
        if(user.isPresent) {
            val userCart: Cart = cartRepository.findCartByUserId(cart.userId) ?: return
            if(userCart.products.isEmpty()) return
            val order = Order(
                orderValue = userCart.cartValue,
                orderStatus = "PLACED",
                products = listOf<Product>()+userCart.products,
                user = user.get()
            )
            orderRepository.save(order)
            removeProductsFromCart(user.get().userId)

        }
    }

    fun removeProductsFromCart(userId:Long) {
        val cart:Cart? = cartRepository.findCartByUserId(userId)
        if(cart != null) {
            cart.cartValue = 0.0
            cart.products = mutableListOf()

            cartRepository.save(cart)
        }
    }

    fun cancelOrder(orderDTO:OrderDTO) {
        orderRepository.cancelOrder(orderDTO.orderId)
    }


}