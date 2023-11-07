package com.zara.product.priceservice.repository;


import com.zara.product.priceservice.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    Optional<List<Price>> findByBrandIdAndProductId(Integer brandId, Integer productId);
}
