package benedict.meta.control.service.constants

object CheckServiceConstants {
    const val PAYMENT_INTERVAL_TWICE_A_MONTH: String = "twice_a_month"
    const val PAYMENT_INTERVAL_MONTHLY: String = "monthly"
    const val PAYMENT_INTERVAL_QUARTERLY: String = "quarterly"
    const val PAYMENT_INTERVAL_HALF_A_YEAR: String = "half_a_year"
    const val PAYMENT_INTERVAL_YEARLY: String = "yearly"

    // Regex: MM-DD
    val START_DATE_REGEX: Regex = Regex("((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0]))")
}