package com.demo.shopping.DTO

import com.demo.shopping.beans.Product
import javax.persistence.Id

class CartDTO(
    val userId: Long = 0,
    val productIdList:List<Long> = listOf()
) {


}