package com.acme.adapter.out.persistence

import com.acme.application.domain.model.Product
import com.acme.application.domain.model.ProductCategory
import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import kotlin.test.Test
import kotlin.test.assertEquals

@QuarkusTest
class ProductMapperTest {

    @Inject
    private lateinit var productMapper: ProductMapper

    @Test
    fun `should keep same data when map domain entity to panache entity`() {
        val product = mockProduct()
        val productPanacheEntity = productMapper.mapToPanacheEntity(product)

        assertEquals(product.name, productPanacheEntity.name)
        assertEquals(product.description, productPanacheEntity.description)
        assertEquals(product.price, productPanacheEntity.price)
        assertEquals(product.productStock, productPanacheEntity.productStock)
        assertEquals(product.productCategory, productPanacheEntity.productCategory)
    }

    @Test
    fun `should keep same data when map panache entity to domain_entity`() {
        val productPanacheEntity = mockProductPanacheEntity()
        val product = productMapper.mapToDomainEntity(productPanacheEntity)

        assertEquals(productPanacheEntity.idProduct, product.idProduct)
        assertEquals(productPanacheEntity.name, product.name)
        assertEquals(productPanacheEntity.description, product.description)
        assertEquals(productPanacheEntity.price, product.price)
        assertEquals(productPanacheEntity.productStock, product.productStock)
        assertEquals(productPanacheEntity.productCategory, product.productCategory)
    }

    private fun mockProduct(): Product {
        return Product(null, "Papel Sulfite A4",
            "A4, 75g, 210mmx297mm, Caixa com 10 resmas - 5000 Folhas"
            ,289.10f, 1000, ProductCategory.BRINQUEDOS ,null)
    }

    private fun mockProductPanacheEntity(): ProductPanacheEntity {
        val productPanacheEntity = ProductPanacheEntity()
        productPanacheEntity.idProduct = 422
        productPanacheEntity.name = "Papel Sulfite A4"
        productPanacheEntity.description = "A4, 75g, 210mmx297mm, Caixa com 10 resmas - 5000 Folhas"
        productPanacheEntity.price = 289.10f
        productPanacheEntity.productStock = 1000
        productPanacheEntity.productCategory = ProductCategory.BRINQUEDOS

        return productPanacheEntity
    }
}