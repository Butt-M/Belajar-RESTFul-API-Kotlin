package github.buttm.restfulapi.belajarrestfulapi.controller

import github.buttm.restfulapi.belajarrestfulapi.Error.NotFoundException
import github.buttm.restfulapi.belajarrestfulapi.Error.UnAuthorizedException
import github.buttm.restfulapi.belajarrestfulapi.model.WebResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException):
            WebResponse<String>{
        return WebResponse(
            code = 400,
            status = "Bad Request",
            data  = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String>{
        return WebResponse(
            code = 404,
            status = "Not Found",
            data  = "Not Found"
        )
    }

    @ExceptionHandler(value = [UnAuthorizedException::class])
    fun unauthorized(unAuthorizedException: UnAuthorizedException): WebResponse<String>{
        return WebResponse(
            code = 401,
            status = "Unauthorized",
            data  = "Please put your X-Api-Key"
        )
    }
}