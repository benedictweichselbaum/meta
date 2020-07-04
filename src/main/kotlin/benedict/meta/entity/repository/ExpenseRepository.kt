package benedict.meta.entity.repository

import benedict.meta.entity.data.Expense
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository : CrudRepository<Expense, Long>