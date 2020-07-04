package benedict.meta.control.service

import benedict.meta.control.service.constants.CheckServiceConstants
import benedict.meta.exceptions.ExceptionConstants
import benedict.meta.exceptions.InvalidPaymentIntervalException
import org.springframework.stereotype.Service

@Service
class CheckPaymentIntervalService {

    private val INTERVAL_SET: Set<String> = setOf(
            CheckServiceConstants.PAYMENT_INTERVAL_HALF_A_YEAR,
            CheckServiceConstants.PAYMENT_INTERVAL_MONTHLY,
            CheckServiceConstants.PAYMENT_INTERVAL_QUARTERLY,
            CheckServiceConstants.PAYMENT_INTERVAL_TWICE_A_MONTH,
            CheckServiceConstants.PAYMENT_INTERVAL_YEARLY
    )

    fun checkPaymentInterval (paymentInterval: String) {
        if (!INTERVAL_SET.contains(paymentInterval)) {
            throw InvalidPaymentIntervalException(ExceptionConstants.PAYMENT_INTERVAL_ERROR_MESSAGE)
        }
    }
}