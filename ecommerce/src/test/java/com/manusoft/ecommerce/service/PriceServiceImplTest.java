package com.manusoft.ecommerce.service;

import com.manusoft.ecommerce.dto.PriceDto;
import com.manusoft.ecommerce.exception.PriceNotFoundException;
import com.manusoft.ecommerce.model.Price;
import com.manusoft.ecommerce.repository.PriceRepository;
import com.manusoft.ecommerce.service.impl.PriceServiceImpl;
import com.manusoft.ecommerce.utils.PriceTestsUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {

    @Mock
    PriceRepository priceRepository;

    @InjectMocks
    PriceServiceImpl priceService;

    @BeforeEach
    void setUp(){}

    Logger LOGGER = LoggerFactory.getLogger(PriceServiceImplTest.class);

    @Test
    void testGetProductPriceByParamsShouldReturnMaxPriorityBetweenDatesOK() {
        LOGGER.info(">> PriceServiceImplTest testGetProductPriceByParamsShouldReturnMaxPriorityBetweenDatesOK()");

        List<Price> priceList = PriceTestsUtils.getPriceList();
        when(priceRepository.findPricesByProductIdAndBrandId(anyLong(), anyLong())).thenReturn(priceList);

        PriceDto expectedPriceDto = PriceDto.builder().price(33.33).priceList(3).startDate("2020-06-16-00.00.00")
                        .endDate("2020-12-31-23.59.59").productId(1).brandId(1).build();

        assertEquals(priceService.getProductPriceByParams(LocalDateTime.parse("2020-06-16T16:00:00"), 1L, 1L), expectedPriceDto);
        LOGGER.info("<< PriceServiceImplTest testGetProductPriceByParamsShouldReturnMaxPriorityBetweenDatesOK()");
    }

    @Test
    void testGetProductPriceByParamsValueNotFoundThrowsPriceNotFoundException() {
        LOGGER.info(">> PriceServiceImplTest testGetProductPriceByParamsValueNotFoundThrowsPriceNotFoundException()");
        List<Price> priceList = PriceTestsUtils.getPriceList();

        when(priceRepository.findPricesByProductIdAndBrandId(anyLong(), anyLong())).thenReturn(priceList);

        assertThrows(PriceNotFoundException.class,
                () -> priceService.getProductPriceByParams(LocalDateTime.parse("2024-06-16T16:00:00"), 1L, 1L));
        LOGGER.info("<< PriceServiceImplTest testGetProductPriceByParamsValueNotFoundThrowsPriceNotFoundException()");
    }

}
