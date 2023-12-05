package com.manusoft.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
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

    private Double price;

    private String curr;

}
