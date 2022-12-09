package com.tooltime.invoiceservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class InvoicePositionInputModel {
    
    private String description;
    
    private BigDecimal amount;

}
