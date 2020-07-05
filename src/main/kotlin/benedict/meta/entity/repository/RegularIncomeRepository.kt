package benedict.meta.entity.repository

import benedict.meta.entity.data.RegularIncome
import org.springframework.data.repository.CrudRepository

interface RegularIncomeRepository : CrudRepository<RegularIncome, Long>