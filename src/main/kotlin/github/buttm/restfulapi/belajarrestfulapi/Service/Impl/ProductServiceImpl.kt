package github.buttm.restfulapi.belajarrestfulapi.Service.Impl

import github.buttm.restfulapi.belajarrestfulapi.Error.NotFoundException
import github.buttm.restfulapi.belajarrestfulapi.Service.ProductServices
import github.buttm.restfulapi.belajarrestfulapi.Validation.ValidationUtil
import github.buttm.restfulapi.belajarrestfulapi.database.Product
import github.buttm.restfulapi.belajarrestfulapi.model.CreateProductRequest
import github.buttm.restfulapi.belajarrestfulapi.model.ListProductRequest
import github.buttm.restfulapi.belajarrestfulapi.model.ProductResponse
import github.buttm.restfulapi.belajarrestfulapi.model.UpdateProductRequest
import github.buttm.restfulapi.belajarrestfulapi.repository.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(val productRepository: ProductRepository,
    val validationUtil: ValidationUtil): ProductServices {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = findProductById(id)
        return convertProductToProductResponse(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = findProductById(id)

        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductById(id)
        productRepository.delete(product)
    }

    override fun getAllProduct(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products: List<Product> = page.get().collect(Collectors.toList())

        return products.map { convertProductToProductResponse(it) }
    }

    private fun findProductById(id: String): Product{
        val product = productRepository.findByIdOrNull(id)
        if(product == null){
            throw NotFoundException()
        }else {
            return product
        }
    }

    private  fun convertProductToProductResponse(product: Product):ProductResponse{
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}