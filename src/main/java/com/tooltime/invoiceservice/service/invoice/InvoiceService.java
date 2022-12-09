package com.tooltime.invoiceservice.service.invoice;

import com.tooltime.invoiceservice.model.InvoiceInputModel;
import com.tooltime.invoiceservice.model.InvoiceModel;

public interface InvoiceService {

    InvoiceModel create(InvoiceInputModel invoiceInputModel);
    
}
