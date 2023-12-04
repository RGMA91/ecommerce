package com.manusoft.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PRICES")
public class Price implements Serializable {

    private int brandId;

    private String startDate;

    private String endDate;

    @Id
    @GeneratedValue
    private int priceList;

    private int productId;

    private int priority;

    private float price;

    private String curr;

}
