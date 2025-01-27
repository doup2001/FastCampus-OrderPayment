package lecture.fastcampus.ecommerce.fpay.application.port.in;


import lecture.fastcampus.ecommerce.fpay.representation.request.order.CancelOrder;

public interface PaymentCancelUseCase {

    boolean paymentCancel(CancelOrder cancelOrder) throws Exception;
}
