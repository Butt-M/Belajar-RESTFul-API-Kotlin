package github.buttm.restfulapi.belajarrestfulapi.database

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "api_keys")
data class ApiKey (

    @Id
    val id: String

)