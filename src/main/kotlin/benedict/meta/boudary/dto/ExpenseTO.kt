package benedict.meta.boudary.dto

import lombok.NoArgsConstructor
import java.time.LocalDateTime

@NoArgsConstructor
data class ExpenseTO (
        var amount: Long,
        var label: String,
        var description: String,
        var regularExpense: Long? = null,
        var transactionDate: LocalDateTime
)