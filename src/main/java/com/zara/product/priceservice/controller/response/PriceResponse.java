package com.zara.product.priceservice.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class PriceResponse {
    private Integer productId;
    private Integer brandId;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
