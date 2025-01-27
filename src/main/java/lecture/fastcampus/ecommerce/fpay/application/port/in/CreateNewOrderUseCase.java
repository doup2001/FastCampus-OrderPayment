package lecture.fastcampus.ecommerce.fpay.application.port.in;


import lecture.fastcampus.ecommerce.fpay.domain.order.Order;
import lecture.fastcampus.ecommerce.fpay.representation.request.order.PurchaseOrder;

public interface CreateNewOrderUseCase {
    Order createOrder(PurchaseOrder newOrder) throws Exception;
}
