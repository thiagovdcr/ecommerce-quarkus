package com.acme.adapter.out.persistence

import com.acme.application.domain.model.Product
import com.acme.application.port.out.ProductRepositoryPort
import io.quarkus.hibernate.orm.panache.Panache
import io.quarkus.hibernate.orm.panache.PanacheEntity
import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import kotlinx.coroutines.flow.merge

@ApplicationScoped
class ProductRepository: PanacheRepository<ProductPanacheEntity>, ProductRepositoryPort {

    @Inject
    lateinit var productMapper: ProductMapper

    override fun getAllProducts(): List<Product> {
        val productsPanacheEntity = findAll().list<ProductPanacheEntity>()
        return productsPanacheEntity.map { productMapper.mapToDomainEntity(it) }
    }

    override fun getProduct(idProduct: Long): Product {
        val productPanacheEntity = find("idProduct", idProduct).firstResult<ProductPanacheEntity>()
        return productMapper.mapToDomainEntity(productPanacheEntity)
    }

    override fun saveProduct(product: Product): Product {
        val productPanacheEntity = productMapper.mapToPanacheEntity(product)
        persist(productPanacheEntity)
        return productMapper.mapToDomainEntity(productPanacheEntity)
    }

    override fun updateProduct(product: Product) {
        update("name=?1, description=?2, price=?3, productStock=?4," +
                " productCategory=?5, productImage=?6 where idProduct=?7", product.name,
            product.description, product.price, product.productStock, product.productCategory,
            product.productImage, product.idProduct)
    }

    override fun removeProduct(idProduct: Long) {
        deleteById(idProduct)
    }

}