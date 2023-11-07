package com.zara.product.priceservice.service;

import com.zara.product.priceservice.controller.response.PriceResponse;
import com.zara.product.priceservice.model.Price;
import com.zara.product.priceservice.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public ResponseEntity<PriceResponse> getPriceInfo(Integer brandId, Integer productId, String startDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        LocalDateTime priceDate = LocalDateTime.parse(startDate, formatter);

        Price priceItem = priceRepository.findByBrandIdAndProductId(brandId, productId)
                .orElse(null)
                .stream()
                .filter(price -> price.getStartDate().isBefore(priceDate)
                        && price.getEndDate().isAfter(priceDate))
                .max(Comparator.comparing(Price::getPriority))
                .orElse(null);

        if(Objects.isNull(priceItem)){
            return ResponseEntity.notFound().build();
        }

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(priceItem.getProductId())
                .brandId(priceItem.getBrandId())
                .price(priceItem.getPrice())
                .startDate(priceItem.getStartDate())
                .endDate(priceItem.getEndDate())
                .build();

        return new ResponseEntity<>(priceResponse, HttpStatus.OK);
    }

}
