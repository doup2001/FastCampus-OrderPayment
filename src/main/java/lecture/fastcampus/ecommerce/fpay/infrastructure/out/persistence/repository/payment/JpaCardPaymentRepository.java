package lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.payment;


import lecture.fastcampus.ecommerce.fpay.domain.payment.card.CardPayment;
import lecture.fastcampus.ecommerce.fpay.infrastructure.out.persistence.repository.JpaBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCardPaymentRepository extends JpaBaseRepository<CardPayment, String> {
}