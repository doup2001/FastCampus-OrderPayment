package lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss;

import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentApproved;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentApproved;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TossPayments  {

    private final TossPaymentsAPIs tossClient;

    public ResponsePaymentApproved requestPaymentApprove(PaymentApproved requestMessage) throws IOException {
        Response<ResponsePaymentApproved> response = tossClient.paymentFulFill(requestMessage).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new IOException(response.message());
    }

}
