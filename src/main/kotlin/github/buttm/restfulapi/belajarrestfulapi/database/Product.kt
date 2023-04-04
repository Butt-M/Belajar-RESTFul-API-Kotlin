package github.buttm.restfulapi.belajarrestfulapi.database

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "products")
data class Product (
    @Id
    val id: String,

    @Column(name="name")
    var name: String,

    @Column(name="price")
    var price: Long,

    @Column(name="quantity")
    var quantity: Int,

    @Column(name="created_at")
    var createdAt: Date,

    @Column(name="updated_at")
    var updatedAt: Date?
)