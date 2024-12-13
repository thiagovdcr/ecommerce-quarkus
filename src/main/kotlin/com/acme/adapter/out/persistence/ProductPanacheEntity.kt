package com.acme.adapter.out.persistence

import com.acme.application.domain.model.ProductCategory
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity( name="Product")
class ProductPanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    var idProduct: Long? = null
    @Column(name = "name")
    var name: String = ""
    var description: String = ""
    var price: Float = 0f
    @Column(name="product_stock")
    var productStock: Int = 0
    @Column(name = "id_product_category")
    var productCategory: ProductCategory? = null
    @Column(name = "product_image")
    var productImage: ByteArray? = null
}

