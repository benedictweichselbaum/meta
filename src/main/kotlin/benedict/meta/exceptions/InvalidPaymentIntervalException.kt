package benedict.meta.exceptions

import java.lang.RuntimeException

class InvalidPaymentIntervalException (override val message: String?) : RuntimeException (message)