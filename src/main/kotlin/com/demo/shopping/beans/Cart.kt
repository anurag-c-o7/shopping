package com.demo.shopping.beans

import javax.persistence.*

@Entity
@Table(name="cart")
class Cart(

    @Id
    @GeneratedValue
    val cartId:Long = 0,

    var cartValue:Double = 0.0,

    @OneToOne(mappedBy = "cart")
    val user:UserProfile?=null,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @Column(name="product_id")
    var products:List<Product> = mutableListOf()

) {


}