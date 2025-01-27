package lecture.fastcampus.ecommerce.fpay.application.port.in;


import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentApproved;

import java.io.IOException;

public interface PaymentFullfillUseCase {
    String paymentApproved(PaymentApproved paymentInfo) throws IOException;
}
