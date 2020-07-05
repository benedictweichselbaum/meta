package benedict.meta.entity.data

import org.springframework.data.jpa.repository.Temporal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.TemporalType

@Entity
@Table(name = "expense", schema = "meta")
data class Expense (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        var amount: Long,
        var label: String,
        var description: String,
        var regularExpense: Long?,
        @Temporal(TemporalType.TIMESTAMP) var transactionDate: LocalDateTime = LocalDateTime.now()
)