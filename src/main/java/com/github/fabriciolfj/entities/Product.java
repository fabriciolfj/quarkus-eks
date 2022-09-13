package com.github.fabriciolfj.entities;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    private String code;
    private String describe;
    private BigDecimal price;
    private Category category;
}
