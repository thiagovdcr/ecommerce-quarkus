package com.acme.application.domain.model

import java.io.File
import java.nio.file.Files

data class Product(var idProduct: Long? = null, var name: String = "", var description: String = "",
                   var price: Float = 0f, var productStock: Int = 0,
                   var productCategory: ProductCategory? = null,
                   var productImage: ByteArray? = null) {

    fun setImageAsByteArray(imagePath: String) {
        val imageFile = File(imagePath)

        if (imageFile.exists() && imageFile.isFile) {

            productImage = Files.readAllBytes(imageFile.toPath())
        } else {
            println("File not found or is not a valid file")
        }
    }

}