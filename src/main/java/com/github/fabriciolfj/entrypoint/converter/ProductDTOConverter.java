package com.github.fabriciolfj.entrypoint.converter;

import com.github.fabriciolfj.entities.Category;
import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.entrypoint.dto.request.ProductRequest;

import java.util.UUID;

public class ProductDTOConverter {

    private ProductDTOConverter() { }

    public static Product toEntity(final ProductRequest request) {
        return Product.builder()
                .code(UUID.randomUUID().toString())
                .describe(request.getDescribe())
                .price(request.getPrice())
                .category(Category.builder().describe(request.getCategory()).build())
                .build();
    }
}
