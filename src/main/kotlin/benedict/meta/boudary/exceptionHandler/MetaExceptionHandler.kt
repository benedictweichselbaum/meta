package benedict.meta.boudary.exceptionHandler

import benedict.meta.boudary.dto.ErrorTO
import benedict.meta.exceptions.InvalidPaymentIntervalException
import benedict.meta.exceptions.InvalidStartPaymentDateException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class MetaExceptionHandler {

    @ExceptionHandler(value = [(InvalidStartPaymentDateException::class)])
    fun handleOpenWeatherException (exception: InvalidStartPaymentDateException, request: WebRequest):
            ResponseEntity<ErrorTO> =
            ResponseEntity.status(400).body(ErrorTO(exception.message))

    @ExceptionHandler(value = [(InvalidPaymentIntervalException::class)])
    fun handleOpenWeatherException (exception: InvalidPaymentIntervalException, request: WebRequest):
            ResponseEntity<ErrorTO> =
            ResponseEntity.status(400).body(ErrorTO(exception.message))
}