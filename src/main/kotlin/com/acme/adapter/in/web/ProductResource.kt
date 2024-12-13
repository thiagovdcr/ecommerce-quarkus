package com.acme.adapter.`in`.web

import com.acme.application.domain.model.Product
import com.acme.application.port.`in`.ProductUseCase
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.HeaderParam
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("product")
@ApplicationScoped
class ProductResource(private val productUseCase: ProductUseCase) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getProduct(@HeaderParam("id-product") idProduct: Long): Product {
        return productUseCase.getProduct(idProduct)
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun saveProduct(product: Product): Product {
        return productUseCase.saveProduct(product)
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateProduct(product: Product){
        productUseCase.updateProduct(product)
    }

    @DELETE
    fun removeProduct(@HeaderParam("id-product") idProduct: Long) {
        productUseCase.removeProduct(idProduct)
    }

}