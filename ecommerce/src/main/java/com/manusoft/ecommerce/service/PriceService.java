package com.manusoft.ecommerce.service;

import com.manusoft.ecommerce.model.Price;

import java.time.LocalDateTime;

public interface PriceService {
        Price getProductPriceByParams(LocalDateTime applyingDate, Long productId, Long brandId);

}
