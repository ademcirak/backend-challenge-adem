package com.tooltime.invoiceservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceModel extends InvoiceInputModel {
    
    private UUID id;
    
    private String code;
    
    private BigDecimal totalAmount;
    
    private LocalDateTime issuedAt;
}
