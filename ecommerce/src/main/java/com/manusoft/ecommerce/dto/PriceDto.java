package com.manusoft.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PriceDto {
    private int productId;

    private int brandId;

    private Double price;

    private String startDate;

    private String endDate;

    private int priceList;

}


