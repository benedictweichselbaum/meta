package benedict.meta.control.facade

import benedict.meta.boudary.dto.ExpenseTO
import benedict.meta.control.mapper.ExpenseMapper
import benedict.meta.control.service.ExpenseAvailabilityService
import benedict.meta.entity.data.Expense
import benedict.meta.entity.repository.ExpenseRepository
import benedict.meta.exceptions.ExceptionConstants
import benedict.meta.exceptions.ExpenseNotFoundException
import org.springframework.stereotype.Component
import java.util.stream.Collectors

/**
 * Facade for expense CRUD operations
 */
@Component
class ExpenseFacade (
        private val expenseRepository: ExpenseRepository,
        private val expenseAvailabilityService: ExpenseAvailabilityService
) {

    /**
     * Saves new expense to database
     */
    fun saveNewExpense (expenseTO: ExpenseTO): Long =
        this.expenseRepository.save(ExpenseMapper.mapTOtoEntity(expenseTO)).id!!

    /**
     * Updates a expense by id
     */
    fun updateExpense (expenseTO: ExpenseTO, id: Long) {
        this.expenseAvailabilityService.checkIfExpenseExists(id)
        val updatedExpense: Expense = ExpenseMapper.mapTOtoEntity(expenseTO)
        updatedExpense.id = id
        this.expenseRepository.save(updatedExpense)
    }

    /**
     * Read singe expense from database
     */
    fun readSingleExpense (id: Long): ExpenseTO =
            ExpenseMapper.mapEntityToTO(
                    this.expenseRepository.findById(id)
                            .orElseThrow{ExpenseNotFoundException(ExceptionConstants.EXPENSE_NOT_FOUND_ERROR_MESSAGE)}
            )

    /**
     * Read all expenses from database
     */
    fun readAllExpenses (): List<ExpenseTO> =
            this.expenseRepository.findAll()
                    .toList()
                    .stream()
                    .map{entity -> ExpenseMapper.mapEntityToTO(entity)}
                    .collect(Collectors.toList())

    /**
     * Deletes a single expense from the database
     */
    fun deleteSingleExpense (id: Long) {
        this.expenseAvailabilityService.checkIfExpenseExists(id)
        this.expenseRepository.deleteById(id)
    }
}