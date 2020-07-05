package benedict.meta.boudary

import benedict.meta.boudary.dto.ExpenseTO
import benedict.meta.control.facade.ExpenseFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
class ExpenseApi (
        private val expenseFacade: ExpenseFacade
) {

    /**
     * API-Method for saving a new expense. Calls facade.
     */
    @PostMapping
    fun saveExpense (@RequestBody expenseTO: ExpenseTO): ResponseEntity<Void> {
        val newExpenseId: Long = this.expenseFacade.saveNewExpense(expenseTO)
        return ResponseEntity.created(URI.create("expenses/$newExpenseId")).build()
    }

    /**
     * API-Method for updating an expense. Calls facade. Throws exception if expense
     * does not exists.
     */
    @PutMapping("/{id}")
    fun updateExpenseById (@PathVariable("id") id: Long,
                       @RequestBody expenseTO: ExpenseTO) : ResponseEntity<Void> {
        this.expenseFacade.updateExpense(expenseTO, id)
        return ResponseEntity.ok().build()
    }

    /**
     * API-Method for reading a single expense. Uses id to identify.
     */
    @GetMapping("/{id}")
    fun getExpenseById (@PathVariable("id") id: Long): ResponseEntity<ExpenseTO> =
            ResponseEntity.ok(this.expenseFacade.readSingleExpense(id))

    /**
     * API-Method for reading all expenses.
     */
    @GetMapping
    fun getAllExpenses (): ResponseEntity<List<ExpenseTO>> =
            ResponseEntity.ok(this.expenseFacade.readAllExpenses())

    /**
     * API-Method for deleting a expense. Uses id to identify
     */
    @DeleteMapping("/{id}")
    fun deleteExpenseById (@PathVariable("id") id: Long): ResponseEntity<Void> {
        this.expenseFacade.deleteSingleExpense(id)
        return ResponseEntity.ok().build()
    }
}