package com.zara.product.priceservice.controller;

import com.zara.product.priceservice.controller.response.PriceResponse;
import com.zara.product.priceservice.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/product/price")
public class PriceController {
    @Autowired
    private PriceService priceService;
    @Operation(summary = "Get product valid price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Valid price not found"),
            @ApiResponse(responseCode = "200", description = "Price found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PriceResponse> getProductSimilarIds(@RequestParam("brandId") Integer brandId,
                                                              @RequestParam("productId") Integer productId,
                                                              @RequestParam("startDate") String startDate){
        if (Objects.isNull(brandId) || Objects.isNull(productId) || Objects.isNull(startDate)) {
            return ResponseEntity.badRequest().build();
        }
        return priceService.getPriceInfo(brandId, productId, startDate);
    }
}
