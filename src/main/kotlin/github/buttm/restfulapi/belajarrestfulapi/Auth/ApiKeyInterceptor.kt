package github.buttm.restfulapi.belajarrestfulapi.Auth

import github.buttm.restfulapi.belajarrestfulapi.Error.UnAuthorizedException
import github.buttm.restfulapi.belajarrestfulapi.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor{

    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key")
        if(apiKey == null){
            throw UnAuthorizedException()
        }

        if(!apiKeyRepository.existsById(apiKey)){
            throw UnAuthorizedException()
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        // nothing
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        // nothing
    }
}