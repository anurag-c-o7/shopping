package com.demo.shopping.repository

import com.demo.shopping.beans.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface OrderRepository : JpaRepository<Order,Long>{
    @Modifying
    @Query(nativeQuery = true, value = """update orders set order_status = 'CANCELLED' 
        where order_id =:orderId
    """)
    fun cancelOrder(@Param("orderId") orderId:Long)
}