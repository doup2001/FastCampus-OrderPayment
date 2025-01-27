package lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss;

import lecture.fastcampus.ecommerce.fpay.infrastructure.out.pg.toss.response.ResponsePaymentApproved;
import lecture.fastcampus.ecommerce.fpay.representation.request.payment.PaymentApproved;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TossPaymentsAPIs {

    @POST("payments/confirm")
    Call<ResponsePaymentApproved> paymentFulFill(@Body PaymentApproved requestMessage);

}
