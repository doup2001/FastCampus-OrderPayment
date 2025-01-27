package lecture.fastcampus.ecommerce.fpay.application.port.out.repository;


import lecture.fastcampus.ecommerce.fpay.domain.payment.TransactionType;

public interface TransactionTypeRepository {
    TransactionType findById(String paymentKey);
    void save(TransactionType paymentDetailInfo);
}
