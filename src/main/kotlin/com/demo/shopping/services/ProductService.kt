package com.demo.shopping.services

import com.demo.shopping.beans.Product
import com.demo.shopping.repository.ProductRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class ProductService(val productRepository: ProductRepository) {

    fun addProduct(product:Product) {
        val newProduct = Product(
            productName = product.productName,
            price = product.price
        )

        productRepository.save(newProduct)
    }
}