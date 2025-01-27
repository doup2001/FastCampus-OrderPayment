package lecture.fastcampus.ecommerce.fpay.application.port.out.repository;


import lecture.fastcampus.ecommerce.fpay.domain.order.Order;

import java.util.UUID;

public interface OrderRepository {
    Order findById(UUID id);
    Order save(Order newOrder);
    boolean removeAll(UUID id);
}
