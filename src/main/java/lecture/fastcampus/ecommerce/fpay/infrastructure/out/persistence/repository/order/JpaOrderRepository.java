package lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.order;


import lecture.fastcampus.ecommerce.fpay.domain.order.Order;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.JpaBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaOrderRepository extends JpaBaseRepository<Order, UUID> {
}
