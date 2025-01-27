package lecture.fastcampus.ecommerce.fpay.application.port.in;


import lecture.fastcampus.ecommerce.fpay.domain.order.Order;

import java.util.UUID;

public interface GetOrderInfoUseCase {
    Order getOrderInfo(UUID orderId);
}
