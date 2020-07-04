package benedict.meta.control.mapper

import benedict.meta.boudary.dto.ExpenseTO
import benedict.meta.entity.data.Expense

object ExpenseMapper {
    fun mapTOtoEntity(to: ExpenseTO): Expense =
            Expense(
                    amount = to.amount,
                    description = to.description,
                    label = to.label,
                    regularExpense = to.regularExpense
            )

    fun mapEntityToTO (entity: Expense): ExpenseTO =
            ExpenseTO(
                    entity.amount,
                    entity.label,
                    entity.description,
                    entity.regularExpense
            )
}