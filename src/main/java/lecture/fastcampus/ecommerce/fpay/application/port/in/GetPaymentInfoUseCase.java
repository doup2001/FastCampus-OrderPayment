package lecture.fastcampus.ecommerce.fpay.application.port.in;


import lecture.fastcampus.ecommerce.fpay.domain.payment.PaymentLedger;

import java.util.List;

public interface GetPaymentInfoUseCase {
    List<PaymentLedger> getPaymentInfo(String paymentKey);
    PaymentLedger getLatestPaymentInfoOnlyOne(String paymentKey);
}
