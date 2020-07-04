package benedict.meta.exceptions

import java.lang.RuntimeException

class InvalidStartPaymentDateException (override val message: String?) : RuntimeException (message)