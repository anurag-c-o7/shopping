package com.demo.shopping.repository

import com.demo.shopping.beans.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order,Long>{
}