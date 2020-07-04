package benedict.meta.control.mapper

import benedict.meta.boudary.dto.RegularExpenseTO
import benedict.meta.entity.data.RegularExpense

object RegularExpenseMapper {

    fun mapTOtoEntity (to: RegularExpenseTO): RegularExpense =
            RegularExpense(
                    amount = to.amount,
                    paymentInterval = to.paymentInterval,
                    startPaymentDate = to.startPaymentDate,
                    label = to.label,
                    description = to.description
            )

    fun mapEntityToTO (entity: RegularExpense): RegularExpenseTO =
            RegularExpenseTO(
                    entity.amount,
                    entity.paymentInterval,
                    entity.startPaymentDate,
                    entity.label,
                    entity.description
            )
}