package github.buttm.restfulapi.belajarrestfulapi.Config

import github.buttm.restfulapi.belajarrestfulapi.database.ApiKey
import github.buttm.restfulapi.belajarrestfulapi.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeader(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "Matamu"

    override fun run(args: ApplicationArguments?) {
        if(!apiKeyRepository.existsById(apiKey)){
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }

}