package com.manusoft.ecommerce.service.impl;

import com.manusoft.ecommerce.dto.PriceDto;
import com.manusoft.ecommerce.exception.PriceNotFoundException;
import com.manusoft.ecommerce.model.Price;
import com.manusoft.ecommerce.repository.PriceRepository;
import com.manusoft.ecommerce.service.PriceService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    public PriceRepository priceRepository;

    ModelMapper modelMapper = new ModelMapper();

    Logger LOGGER = LoggerFactory.getLogger(PriceServiceImpl.class);

    @Override
    public PriceDto getProductPriceByParams(LocalDateTime applyingDate, Long productId, Long brandId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

        LOGGER.debug(">> PriceServiceImpl getProductPriceByParams() applyingDate: {} productId: {} brandId: {}",
                applyingDate, productId, brandId);

        List<Price> productPrices = priceRepository.findPricesByProductIdAndBrandId(productId, brandId);

        LOGGER.debug("-- PriceServiceImpl getProductPriceByParams productPrices obtained from db: {}", productPrices);

        Price priceToApply = productPrices.stream()
                .filter(priceRegistry -> applyingDate.isAfter(LocalDateTime.parse(priceRegistry.getStartDate(), formatter)) &&
                        applyingDate.isBefore(LocalDateTime.parse(priceRegistry.getEndDate(), formatter)))
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("No price data found for params provided"));

        PriceDto priceDto = modelMapper.map(priceToApply, PriceDto.class);

        LOGGER.debug("<< PriceServiceImpl getProductPriceByParams() priceDto: {}", priceDto);

        return priceDto;
    }
}
