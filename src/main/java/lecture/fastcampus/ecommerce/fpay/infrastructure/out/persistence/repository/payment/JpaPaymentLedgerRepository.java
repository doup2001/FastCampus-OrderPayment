package lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.payment;


import lecture.fastcampus.ecommerce.fpay.domain.payment.PaymentLedger;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.JpaBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPaymentLedgerRepository extends JpaBaseRepository<PaymentLedger, String> {
    Optional<List<PaymentLedger>> findByPaymentKey(String paymentKey);

    Optional<PaymentLedger> findTopByPaymentKeyOrderByIdDesc(String paymentKey);
}