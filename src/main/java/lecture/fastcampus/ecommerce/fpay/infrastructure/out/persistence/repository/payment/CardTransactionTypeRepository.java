package lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.payment;

import lecture.fastcampus.ecommerce.fpay.application.port.out.repository.TransactionTypeRepository;
import lecture.fastcampus.ecommerce.fpay.domain.payment.TransactionType;
import lecture.fastcampus.ecommerce.fpay.domain.payment.card.CardPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class CardTransactionTypeRepository implements TransactionTypeRepository {
    private final JpaCardPaymentRepository jpaCardPaymentRepository;

    @Override
    public CardPayment findById(String paymentKey) {
        return jpaCardPaymentRepository.findById(paymentKey)
            .orElseThrow(() -> new NoSuchElementException(String.format("CardPayment with key '%s' not found", paymentKey)));
    }

    @Override
    public void save(TransactionType paymentDetailInfo) {
        jpaCardPaymentRepository.save((CardPayment) paymentDetailInfo);
    }
}
