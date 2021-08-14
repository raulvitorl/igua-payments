package br.com.igua.payments.entity.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igua.payments.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, String>{

}
