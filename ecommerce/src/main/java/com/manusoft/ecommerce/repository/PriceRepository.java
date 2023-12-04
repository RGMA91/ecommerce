package com.manusoft.ecommerce.repository;

import com.manusoft.ecommerce.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    List<Price> findPricesByProductIdAndBrandId(Long productId, Long brandId);

}
