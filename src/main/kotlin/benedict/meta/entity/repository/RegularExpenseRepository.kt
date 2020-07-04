package benedict.meta.entity.repository

import benedict.meta.entity.data.RegularExpense
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RegularExpenseRepository : CrudRepository<RegularExpense, Long>