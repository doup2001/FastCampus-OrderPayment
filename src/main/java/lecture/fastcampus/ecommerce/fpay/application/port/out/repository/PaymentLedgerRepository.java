package lecture.fastcampus.ecommerce.fpay.application.port.out.repository;


import lecture.fastcampus.ecommerce.fpay.domain.payment.PaymentLedger;

import java.util.List;

public interface PaymentLedgerRepository {
    List<PaymentLedger> findAllByPaymentKey(String paymentKey);
    PaymentLedger findOneByPaymentKeyDesc(String paymentKey);
    void save(PaymentLedger paymentLedgerInfo);
    void bulkInsert(List<PaymentLedger> paymentLedgerHistories);
}
