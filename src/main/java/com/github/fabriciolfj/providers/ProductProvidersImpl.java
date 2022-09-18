package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.ProviderSaveProduct;
import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.exceptions.ProductSaveException;
import com.github.fabriciolfj.providers.repositories.ProductRepository;
import com.github.fabriciolfj.providers.repositories.converter.ProductDataConverter;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ProductProvidersImpl implements ProviderSaveProduct {

    private final ProductRepository repository;

    @Override
    @ReactiveTransactional
    public Uni<Void> process(Product product) {
        return repository.saveProduct(ProductDataConverter.toData(product))
                .invoke(e -> log.info("Result save product: {}", e))
                .onFailure()
                .transform(e -> {
                    log.info("Fail save product, details: {}", e.getMessage());
                    return new ProductSaveException();
                })
                .onItem()
                .transformToUni(result -> Uni.createFrom().voidItem());
    }
}
