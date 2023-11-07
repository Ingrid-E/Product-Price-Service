package com.zara.product.priceservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name="Price")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list")
    private Integer priceList;
    @JoinColumn(name = "brand_id")
    private Integer brandId;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "price")
    private Double price;
    @Column(name = "curr")
    private String currency;
}
