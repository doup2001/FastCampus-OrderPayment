package lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.order;

import lecture.fastcampus.ecommerce.fpay.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepository implements lecture.fastcampus.ecommerce.fpay.application.port.out.repository.OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    @Override
    public Order findById(UUID id) {
        return jpaOrderRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("OrderId not found"));
    }

    @Override
    public Order save(Order newOrder) {
        return jpaOrderRepository.save(newOrder);
    }

    @Override
    public boolean removeAll(UUID id) {
        return jpaOrderRepository.deleteById(id);
    }

}
