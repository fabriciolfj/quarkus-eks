package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.ProviderSaveProduct;
import com.github.fabriciolfj.entities.Product;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class SaveProduct {

    private final ProviderSaveProduct provider;

    public Uni<String> execute(final Product product) {
        return provider.process(product)
                .onItem()
                .transform(v -> product.getCode());
    }
}
