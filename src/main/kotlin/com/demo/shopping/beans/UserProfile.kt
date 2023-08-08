package com.demo.shopping.beans

import javax.persistence.*

@Entity
@Table(name="user_profile")
class UserProfile(

    @Id
    @GeneratedValue
    val userId:Long = 0,

    val userName:String,

    val email:String,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    val orders:List<Order> = listOf(),

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="cart_id")
    val cart:Cart?

) {

}