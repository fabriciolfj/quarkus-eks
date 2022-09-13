package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ProviderFindProductsCategory;
import com.github.fabriciolfj.entities.Product;
import io.smallrye.mutiny.Multi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FindProductsCategory {

    private final ProviderFindProductsCategory provider;

    public Multi<Product> execute(final String category) {
        return provider.process(category)
                .invoke(p -> log.info("Product return {}", p));
    }
}
