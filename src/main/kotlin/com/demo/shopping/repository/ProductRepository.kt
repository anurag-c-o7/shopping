package com.demo.shopping.repository

import com.demo.shopping.beans.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product,Long>{
}