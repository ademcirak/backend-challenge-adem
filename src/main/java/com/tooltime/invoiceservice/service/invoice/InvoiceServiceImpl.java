package com.tooltime.invoiceservice.service.invoice;

import com.tooltime.invoiceservice.entitiy.Customer;
import com.tooltime.invoiceservice.entitiy.Invoice;
import com.tooltime.invoiceservice.entitiy.InvoicePosition;
import com.tooltime.invoiceservice.exception.CustomerNotFoundException;
import com.tooltime.invoiceservice.model.InvoiceInputModel;
import com.tooltime.invoiceservice.model.InvoiceModel;
import com.tooltime.invoiceservice.model.InvoicePositionInputModel;
import com.tooltime.invoiceservice.repository.CustomerRepository;
import com.tooltime.invoiceservice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    
    private final CustomerRepository customerRepository;
    
    @Override
    public InvoiceModel create(InvoiceInputModel invoiceInputModel) {
        
        final var invoice = new Invoice();
        
        final var id = UUID.randomUUID();
        invoice.setId(id);
        invoice.setCode(id.toString().split("-")[0]);
        invoice.setTitle(invoiceInputModel.getTitle());
        invoice.setDescription(invoiceInputModel.getDescription());

        final var customer = customerRepository.findById(invoiceInputModel.getCustomerId())
                .orElseThrow(CustomerNotFoundException::new);
        invoice.setCustomer(customer);
        
        final var invoicePositions = invoiceInputModel.getPositions().stream()
                        .map(invoicePositionInputModel -> {
                            final var invoicePosition = new InvoicePosition();
                            invoicePosition.setId(UUID.randomUUID());
                            invoicePosition.setAmount(invoicePositionInputModel.getAmount());
                            invoicePosition.setDescription(invoicePositionInputModel.getDescription());
                            return invoicePosition;
                        }).collect(Collectors.toList());
        
        invoice.setInvoicePosition(invoicePositions);
        invoice.setTotalAmount(invoicePositions.stream()
                .map(InvoicePosition::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        
        final var createdInvoice = invoiceRepository.save(invoice);
        
        final var invoiceModel = new InvoiceModel();
        invoiceModel.setId(createdInvoice.getId());
        invoiceModel.setCode(createdInvoice.getId().toString());
        invoiceModel.setTitle(createdInvoice.getTitle());
        invoiceModel.setDescription(createdInvoice.getDescription());
        invoiceModel.setIssuedAt(createdInvoice.getIssuedAt());
        invoiceModel.setTotalAmount(createdInvoice.getTotalAmount());
        invoiceModel.setCustomerId(createdInvoice.getCustomer().getId());

        final var createdInvoicePositions = createdInvoice.getInvoicePosition().stream()
                .map(invoicePositionInputModel -> {
                    final var invoicePosition = new InvoicePositionInputModel();
                    invoicePosition.setAmount(invoicePositionInputModel.getAmount());
                    invoicePosition.setDescription(invoicePositionInputModel.getDescription());
                    return invoicePosition;
                }).collect(Collectors.toList());
        
        invoiceModel.setPositions(createdInvoicePositions);
        
        return invoiceModel;
    }
    
}
