package com.acme.application.domain.service

import com.acme.application.domain.model.Product
import com.acme.application.port.`in`.ProductUseCase
import com.acme.application.port.out.ProductRepositoryPort
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional

@ApplicationScoped
@Transactional
class ProductService(private val productRepositoryPort: ProductRepositoryPort): ProductUseCase {

    override fun getProduct(idProduct: Long): Product {
        return productRepositoryPort.getProduct(idProduct)
    }

    override fun saveProduct(product: Product): Product {
        product.setImageAsByteArray("/Users/pepperland/Desktop/papel sulfit.png")
        return productRepositoryPort.saveProduct(product)
    }

    override fun updateProduct(product: Product){
        product.setImageAsByteArray("/Users/pepperland/Desktop/papel sulfit.png")
        productRepositoryPort.updateProduct(product)
    }

    override fun removeProduct(idProduct: Long) {
        productRepositoryPort.removeProduct(idProduct)
    }

}