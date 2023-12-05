package com.manusoft.ecommerce.utils;

import com.manusoft.ecommerce.model.Price;

import java.util.List;

public class PriceTestsUtils {

    public static List<Price> getPriceList(){
        return List.of(Price.builder().price(11.11).priceList(1).curr("EUR").startDate("2020-06-14-00.00.00")
                        .endDate("2020-12-31-23.59.59").productId(1).brandId(1).priority(1).build(),
                Price.builder().price(22.22).priceList(2).curr("EUR").startDate("2020-06-15-00.00.00")
                        .endDate("2020-12-31-23.59.59").productId(1).brandId(1).priority(2).build(),
                Price.builder().price(33.33).priceList(3).curr("EUR").startDate("2020-06-16-00.00.00")
                        .endDate("2020-12-31-23.59.59").productId(1).brandId(1).priority(3).build());
    }

}
