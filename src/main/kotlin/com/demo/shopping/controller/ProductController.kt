package com.demo.shopping.controller

import com.demo.shopping.beans.Product
import com.demo.shopping.services.ProductService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService
) {
    @PostMapping("/add-product")
    fun addProduct(@RequestBody product: Product) {
        productService.addProduct(product)
    }
}