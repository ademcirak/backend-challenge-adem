package com.tooltime.invoiceservice.repository;

import com.tooltime.invoiceservice.entitiy.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
