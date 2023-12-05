package com.manusoft.ecommerce.integration;

import com.manusoft.ecommerce.EcommerceApplication;
import com.manusoft.ecommerce.controller.PriceController;
import com.manusoft.ecommerce.dto.PriceDto;
import com.manusoft.ecommerce.model.Price;
import com.manusoft.ecommerce.repository.PriceRepository;
import com.manusoft.ecommerce.utils.PriceTestsUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = EcommerceApplication.class)
public class PriceIntegrationTest {
    @Autowired
    private PriceController priceController;

    @Mock
    private PriceRepository priceRepository;

    Logger LOGGER = LoggerFactory.getLogger(PriceIntegrationTest.class);

    @Test
    void testIntegrationGetProductPriceByParamsShouldReturnMaxPriorityBetweenDatesOK() {
        LOGGER.info(">> PriceIntegrationTest testIntegrationGetProductPriceByParamsShouldReturnMaxPriorityBetweenDatesOK()");
        List<Price> priceList = PriceTestsUtils.getPriceList();

        when(priceRepository.findPricesByProductIdAndBrandId(anyLong(), anyLong())).thenReturn(priceList);

        PriceDto actualPriceDto = priceController.getProductPriceByParams(
                LocalDateTime.parse("2020-06-14T16:00:00"), 35455L, 1L);

        assertEquals(25.45, actualPriceDto.getPrice());
        LOGGER.info("<< PriceIntegrationTest testIntegrationGetProductPriceByParamsShouldReturnMaxPriorityBetweenDatesOK()");

    }

}
