package com.manusoft.ecommerce.service;

import com.manusoft.ecommerce.dto.PriceDto;

import java.time.LocalDateTime;

public interface PriceService {
        PriceDto getProductPriceByParams(LocalDateTime applyingDate, Long productId, Long brandId);

}
