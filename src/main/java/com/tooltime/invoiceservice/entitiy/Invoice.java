package com.tooltime.invoiceservice.entitiy;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="invoice")
@Getter
@Setter
public class Invoice {
    
    @Id
    private UUID id;
    
    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String title;
    
    private String description;
    
    private LocalDateTime issuedAt;
    
    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<InvoicePosition> invoicePosition;

    private BigDecimal totalAmount;

}
