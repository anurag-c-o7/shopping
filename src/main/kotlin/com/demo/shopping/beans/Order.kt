package com.demo.shopping.beans

import java.util.Date
import javax.persistence.*

@Entity
@Table(name="orders")
class Order(

    @Id
    @GeneratedValue
    val orderId:Long = 0,

    val orderValue:Double=0.0,

    val placedTime:Date?=null,

    val orderStatus:String?=null,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="user_profile_id")
    val user:UserProfile?=null,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val products:List<Product>? = null
) {


}