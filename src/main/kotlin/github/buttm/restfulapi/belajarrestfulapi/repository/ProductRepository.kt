package github.buttm.restfulapi.belajarrestfulapi.repository

import github.buttm.restfulapi.belajarrestfulapi.database.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {
}