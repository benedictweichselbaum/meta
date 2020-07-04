package benedict.meta.control.facade

import benedict.meta.boudary.dto.ExpenseTO
import benedict.meta.control.mapper.ExpenseMapper
import benedict.meta.entity.data.Expense
import benedict.meta.entity.repository.ExpenseRepository
import org.springframework.stereotype.Component

@Component
class ExpenseFacade (
        private val expenseRepository: ExpenseRepository
) {

    // Saves new Entity and returns id
    fun saveNewExpense (expenseTO: ExpenseTO): Long =
        this.expenseRepository.save(ExpenseMapper.mapTOtoEntity(expenseTO)).id!!
}