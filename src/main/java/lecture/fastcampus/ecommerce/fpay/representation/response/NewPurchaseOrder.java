package lecture.fastcampus.ecommerce.fpay.representation.response;

import lecture.fastcampus.ecommerce.fpay.domain.order.Order;
import lecture.fastcampus.ecommerce.fpay.domain.order.OrderItem;
import lecture.fastcampus.ecommerce.fpay.domain.order.OrderStatus;
import lecture.fastcampus.ecommerce.fpay.representation.request.order.Orderer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Slf4j
public class NewPurchaseOrder {
    private final UUID orderId;

    private final Orderer orderer;

    private final String paymentId;

    private final int totalPrice;

    private final OrderStatus status;

    @Getter
    private List<NewPurchaseOrderItem> items = new ArrayList<>();

    private NewPurchaseOrder(UUID id, String name, String phoneNumber, String paymentId, int totalPrice, OrderStatus status, List<OrderItem> items) {
        this.orderId = id;
        this.orderer = new Orderer(name, phoneNumber);
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.items = NewPurchaseOrderItem.from(items);
    }

    public static NewPurchaseOrder from(Order order) {
        log.info("orderItems -> {}", order.getItems());
        return new NewPurchaseOrder(order.getOrderId(), order.getName(), order.getPhoneNumber(), order.getPaymentId(), order.getTotalPrice(),
                order.getStatus(), order.getItems());
    }
}
