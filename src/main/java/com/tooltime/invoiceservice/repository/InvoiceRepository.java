package com.tooltime.invoiceservice.repository;

import com.tooltime.invoiceservice.entitiy.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, UUID> {
}
