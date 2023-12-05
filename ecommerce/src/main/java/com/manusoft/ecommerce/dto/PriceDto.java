package com.manusoft.ecommerce.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceDto {
    private int productId;

    private int brandId;

    private float price;

    private String startDate;

    private String endDate;

    private int priceList;

}


