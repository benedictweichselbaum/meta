package benedict.meta.boudary.dto

import lombok.NoArgsConstructor

@NoArgsConstructor
data class ExpenseTO (
        var amount: Long,
        var label: String,
        var description: String,
        var regularExpense: Long? = null
)