package lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.settlements;


import lecture.fastcampus.ecommerce.fpay.domain.settlements.PaymentSettlements;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.JpaBaseRepository;

import java.util.Optional;

public interface JpaPaymentSettlementsRepository extends JpaBaseRepository<PaymentSettlements, Integer> {
    Optional<PaymentSettlements> findByPaymentKey(String paymentKey);
}
