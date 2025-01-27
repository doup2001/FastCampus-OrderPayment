package lecture.fastcampus.ecommerce.fpay.application.port.out.api;


import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentApproved;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentCancel;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentSettlements;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentApproved;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentCancel;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentSettlement;

import java.io.IOException;
import java.util.List;

public interface PaymentAPIs {
    ResponsePaymentApproved requestPaymentApprove(PaymentApproved requestMessage) throws IOException;
    boolean isPaymentApproved(String status);
    ResponsePaymentCancel requestPaymentCancel(String paymentKey, PaymentCancel cancelMessage) throws IOException;
    List<ResponsePaymentSettlements> requestPaymentSettlement(PaymentSettlement paymentSettlement) throws IOException;
}
