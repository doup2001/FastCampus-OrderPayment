package lecture.fastcampus.ecommerce.fpay.domain.payment;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lecture.fastcampus.ecommerce.fpay.domain.payment.card.CardPayment;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentApproved;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.payment.ResponsePaymentCommon;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class TransactionType {
    public static TransactionType convertToTransactionType(ResponsePaymentCommon commonMessage) {
        return switch (commonMessage.getMethod()) {
            case "카드" -> CardPayment.from((ResponsePaymentApproved) commonMessage);
            default ->
                throw new RuntimeException("Unsupported TransactionType method ::: " + commonMessage.getMethod());
        };
    }
}
