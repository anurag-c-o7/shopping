package com.demo.shopping.beans

import javax.persistence.*

@Entity
@Table(name="product")
class Product(

    @Id
    @GeneratedValue
    val productId:Long = 0,

    val productName:String,

    val price:Double = 0.0,

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    val orders:List<Order> = listOf(),

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    var carts:List<Cart> = mutableListOf()
) {
}