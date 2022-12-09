package com.tooltime.invoiceservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceInputModel {

    private String title;
    
    private String description;
    
    private UUID customerId;
    
    private List<InvoicePositionInputModel> positions;

}
