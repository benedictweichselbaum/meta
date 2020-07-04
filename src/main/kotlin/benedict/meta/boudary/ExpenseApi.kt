package benedict.meta.boudary

import benedict.meta.boudary.dto.ExpenseTO
import benedict.meta.control.facade.ExpenseFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
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

    @PostMapping
    fun saveExpense (@RequestBody expenseTO: ExpenseTO): ResponseEntity<Void> {
        val newExpenseId: Long = this.expenseFacade.saveNewExpense(expenseTO)
        return ResponseEntity.created(URI.create("expenses/$newExpenseId")).build()
    }

}