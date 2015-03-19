package com.globant.app.persistence.repositories;

import com.globant.app.domain.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepo extends CrudRepository<Payment, Long>{
}
