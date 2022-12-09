package com.tooltime.invoiceservice.controller.dto;

import com.tooltime.invoiceservice.model.InvoiceInputModel;
import com.tooltime.invoiceservice.model.InvoiceModel;
import com.tooltime.invoiceservice.service.invoice.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    
    private final InvoiceService invoiceService;
    
    @PostMapping
    public InvoiceModel createInvoice(@RequestBody InvoiceInputModel invoiceInputModel) {
        return invoiceService.create(invoiceInputModel);   
    }

}
