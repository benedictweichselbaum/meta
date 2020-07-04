package benedict.meta.boudary.dto

import lombok.NoArgsConstructor

@NoArgsConstructor
data class RegularExpenseTO (
        var amount: Long,
        var paymentInterval: String,
        var startPaymentDate: String,
        var label: String,
        var description: String
)