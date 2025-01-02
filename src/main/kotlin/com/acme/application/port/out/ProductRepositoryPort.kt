package com.acme.application.port.out

import com.acme.application.domain.model.Product

interface ProductRepositoryPort {

    fun getAllProducts(): List<Product>
    fun getProduct(idProduct: Long): Product
    fun saveProduct(product: Product): Product
    fun updateProduct(product: Product)
    fun removeProduct(idProduct: Long)

}