package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ProviderFindProduct;
import com.github.fabriciolfj.entities.Product;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class FindProduct {

    private final ProviderFindProduct findProduct;

    public Uni<Product> execute(final String code) {
        return findProduct.process(code);
    }
}
