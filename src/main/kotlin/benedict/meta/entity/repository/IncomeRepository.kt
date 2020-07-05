package benedict.meta.entity.repository

import benedict.meta.entity.data.Income
import org.springframework.data.repository.CrudRepository

interface IncomeRepository : CrudRepository<Income, Long>