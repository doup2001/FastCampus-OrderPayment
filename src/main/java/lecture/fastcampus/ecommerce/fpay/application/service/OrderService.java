package lecture.fastcampus.ecommerce.fpay.application.service;

import jakarta.transaction.Transactional;
import lecture.fastcampus.ecommerce.fpay.application.port.in.CreateNewOrderUseCase;
import lecture.fastcampus.ecommerce.fpay.application.port.in.GetOrderInfoUseCase;
import lecture.fastcampus.ecommerce.fpay.application.port.out.repository.OrderRepository;
import lecture.fastcampus.ecommerce.fpay.domain.order.Order;
import lecture.fastcampus.ecommerce.fpay.representation.request.order.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements CreateNewOrderUseCase, GetOrderInfoUseCase {
    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public Order createOrder(PurchaseOrder newOrder) throws Exception {
        return orderRepository.save(newOrder.toEntity());
    }

    @Transactional
    @Override
    public Order getOrderInfo(UUID orderId) {
        return orderRepository.findById(orderId);
    }

}
