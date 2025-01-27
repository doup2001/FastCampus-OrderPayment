package lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss;

import lecture.fastcampus.ecommerce.fpay.application.port.out.api.PaymentAPIs;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentApproved;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentCancel;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentSettlements;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentApproved;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentCancel;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentSettlement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TossPayments implements PaymentAPIs {

    private final TossPaymentsAPIs tossClient;

    public ResponsePaymentApproved requestPaymentApprove(PaymentApproved requestMessage) throws IOException {
        Response<ResponsePaymentApproved> response = tossClient.paymentFulFill(requestMessage).execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        throw new IOException(response.message());
    }

    @Override
    public boolean isPaymentApproved(String status) {
        return false;
    }

    @Override
    public ResponsePaymentCancel requestPaymentCancel(String paymentKey, PaymentCancel cancelMessage) throws IOException {
        return null;
    }

    @Override
    public List<ResponsePaymentSettlements> requestPaymentSettlement(PaymentSettlement paymentSettlement) throws IOException {
        return List.of();
    }

}
