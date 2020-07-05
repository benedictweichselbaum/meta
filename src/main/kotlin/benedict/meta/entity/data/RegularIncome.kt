package benedict.meta.entity.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "regular_income", schema = "meta")
data class RegularIncome (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        var amount: Long,
        var paymentInterval: String,
        var startPaymentDate: String,
        var label: String,
        var description: String
)