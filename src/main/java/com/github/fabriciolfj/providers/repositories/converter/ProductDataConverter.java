package com.github.fabriciolfj.providers.repositories.converter;


import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.providers.repositories.data.CategoryData;
import com.github.fabriciolfj.providers.repositories.data.ProductData;

public class ProductDataConverter {

    private ProductDataConverter() { }

    public static ProductData toData(final Product product) {
        return ProductData
                .builder()
                .category(CategoryData.builder().describe(product.getDescribeCategory()).build())
                .code(product.getCode())
                .price(product.getPrice())
                .build();
    }
}
