package benedict.meta.control.service

import benedict.meta.control.service.constants.CheckServiceConstants
import benedict.meta.exceptions.ExceptionConstants
import benedict.meta.exceptions.InvalidStartPaymentDateException
import org.springframework.stereotype.Service

@Service
class CheckStartPaymentDateService {
    fun checkStartPaymentDate(startPaymentDate: String) {
        if (!CheckServiceConstants.START_DATE_REGEX.matches(startPaymentDate)) {
            throw InvalidStartPaymentDateException(ExceptionConstants.START_PAYMENT_DATE_ERROR_MESSAGE)
        }
    }
}