package lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.order;


import lecture.fastcampus.ecommerce.fpay.domain.order.OrderItem;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.JpaBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaOrderItemsRepository extends JpaBaseRepository<OrderItem, UUID> {
}
