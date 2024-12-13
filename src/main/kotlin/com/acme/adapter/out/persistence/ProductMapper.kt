package com.acme.adapter.out.persistence

import com.acme.application.domain.model.Product
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProductMapper {

    fun mapToPanacheEntity(product: Product): ProductPanacheEntity {
        var productPanacheEntity = ProductPanacheEntity()
        productPanacheEntity.idProduct = product.idProduct
        productPanacheEntity.name = product.name
        productPanacheEntity.description = product.description
        productPanacheEntity.price = product.price
        productPanacheEntity.productStock = product.productStock
        productPanacheEntity.productCategory = product.productCategory
        productPanacheEntity.productImage = product.productImage

        return productPanacheEntity
    }

    fun mapToDomainEntity(productPanacheEntity: ProductPanacheEntity): Product {
        return Product(productPanacheEntity.idProduct, productPanacheEntity.name,
            productPanacheEntity.description, productPanacheEntity.price,
            productPanacheEntity.productStock, productPanacheEntity.productCategory, productPanacheEntity.productImage)
    }

}