package lecture.fastcampus.ecommerce.fpay.application.port.out.repository;


import lecture.fastcampus.ecommerce.fpay.domain.settlements.PaymentSettlements;

import java.util.List;

public interface PaymentSettlementsRepository {
    PaymentSettlements findById(String paymentKey);
    void bulkInsert(List<PaymentSettlements> paymentSettlements);
}
