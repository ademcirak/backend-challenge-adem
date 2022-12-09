package com.tooltime.invoiceservice.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {

    @Id
    // @Column(length = 40)
    private UUID id;
    
    private String name;
    
    private String address;

}
