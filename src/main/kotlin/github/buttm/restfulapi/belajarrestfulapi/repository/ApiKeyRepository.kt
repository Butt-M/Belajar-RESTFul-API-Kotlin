package github.buttm.restfulapi.belajarrestfulapi.repository

import github.buttm.restfulapi.belajarrestfulapi.database.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}