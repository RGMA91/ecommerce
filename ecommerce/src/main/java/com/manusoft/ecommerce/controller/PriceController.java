package com.manusoft.ecommerce.controller;

import com.manusoft.ecommerce.model.Price;
import com.manusoft.ecommerce.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class PriceController {

    Logger LOGGER = LoggerFactory.getLogger(PriceController.class);
    @Autowired
    private PriceService priceService;

    @GetMapping("/price/{applyingDate}/{productId}/{brandId}")
    public Price getProductPriceByParams(@PathVariable LocalDateTime applyingDate,
                        @PathVariable Long productId,
                        @PathVariable Long brandId){
        LOGGER.info(">> PriceController getProductPriceByDate() applyingDate: {} productId: {} brandId: {}", applyingDate, productId, brandId);
        Price price = priceService.getProductPriceByParams(applyingDate, productId, brandId);
        LOGGER.info("<< PriceController getProductPriceByDate() price: {}", price);
        return price;
    }

}
