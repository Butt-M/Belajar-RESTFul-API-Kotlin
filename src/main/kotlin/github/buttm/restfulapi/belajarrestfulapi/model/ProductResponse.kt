package github.buttm.restfulapi.belajarrestfulapi.model

import jakarta.persistence.Column
import jakarta.persistence.Id
import java.util.*

class ProductResponse (

    val id: String,

    val name: String,

    val price: Long,

    val quantity: Int,

    val createdAt: Date,

    val updatedAt: Date?

)