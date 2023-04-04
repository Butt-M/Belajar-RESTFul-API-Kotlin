package github.buttm.restfulapi.belajarrestfulapi.controller

import github.buttm.restfulapi.belajarrestfulapi.Service.ProductServices
import github.buttm.restfulapi.belajarrestfulapi.database.Product
import github.buttm.restfulapi.belajarrestfulapi.model.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productServices: ProductServices){

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productServices.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"]
    )
    fun getProductById(@PathVariable("id") id: String): WebResponse<ProductResponse>{
        val productResponse = productServices.get(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun udpateProduct(@PathVariable("id") id: String,
                      @RequestBody updateProductRequest: UpdateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productServices.update(id, updateProductRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @DeleteMapping(
        value = ["api/products/{id}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("id") id: String) : WebResponse<String>{
        productServices.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun getAllProduct(@RequestParam(value = "size", defaultValue = "10")size: Int,
                      @RequestParam(value = "page", defaultValue = "0")page: Int):
            WebResponse<List<ProductResponse>>{
        val request = ListProductRequest(page = page,size = size)
        val response = productServices.getAllProduct(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}