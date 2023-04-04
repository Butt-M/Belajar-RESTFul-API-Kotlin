package github.buttm.restfulapi.belajarrestfulapi.Service

import github.buttm.restfulapi.belajarrestfulapi.model.CreateProductRequest
import github.buttm.restfulapi.belajarrestfulapi.model.ListProductRequest
import github.buttm.restfulapi.belajarrestfulapi.model.ProductResponse
import github.buttm.restfulapi.belajarrestfulapi.model.UpdateProductRequest

interface ProductServices {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun getAllProduct(listProductRequest: ListProductRequest): List<ProductResponse>
}