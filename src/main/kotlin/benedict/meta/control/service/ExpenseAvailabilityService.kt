package benedict.meta.control.service

import benedict.meta.entity.repository.ExpenseRepository
import benedict.meta.exceptions.ExceptionConstants
import benedict.meta.exceptions.ExpenseNotFoundException
import org.springframework.stereotype.Service

@Service
class ExpenseAvailabilityService (
        private val expenseRepository: ExpenseRepository
) {

    fun checkIfExpenseExists (id: Long) {
        if (!this.expenseRepository.existsById(id)) {
            throw ExpenseNotFoundException(ExceptionConstants.EXPENSE_NOT_FOUND_ERROR_MESSAGE)
        }
    }
}