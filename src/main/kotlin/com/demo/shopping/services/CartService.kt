package com.demo.shopping.services

import com.demo.shopping.DTO.CartDTO
import com.demo.shopping.beans.Cart
import com.demo.shopping.beans.Product
import com.demo.shopping.beans.UserProfile
import com.demo.shopping.repository.CartRepository
import com.demo.shopping.repository.ProductRepository
import com.demo.shopping.repository.UserProfileRepository
import org.springframework.stereotype.Service
import java.util.Optional
import javax.transaction.Transactional

@Service
@Transactional
class CartService(
    val cartRepository: CartRepository,
    val userProfileRepository: UserProfileRepository,
    val productRepository: ProductRepository
) {
    fun addToCart(cart:CartDTO) {
        //if(cart.userId == null) return
        val userCart:Cart? = cartRepository.findCartByUserId(cart.userId)
        val user:Optional<UserProfile> = userProfileRepository.findById(cart.userId)
        val addedProducts:List<Product> = productRepository.findAllById(cart.productIdList)

        if(userCart != null) {
            val cartValue:Double = addedProducts
                .map{it.price}
                .fold(userCart.cartValue) { num1: Double, num2: Double ->num1+num2}
            val modifiedCart:Cart = Cart(
                cartId = userCart.cartId,
                user = user.get(),
                products = userCart.products.plus(addedProducts),
                cartValue = cartValue
            )
            cartRepository.save(modifiedCart)
        }
    }
}