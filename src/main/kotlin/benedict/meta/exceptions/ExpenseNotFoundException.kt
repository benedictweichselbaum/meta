package benedict.meta.exceptions

import java.lang.RuntimeException

class ExpenseNotFoundException (override val message: String?) : RuntimeException (message)