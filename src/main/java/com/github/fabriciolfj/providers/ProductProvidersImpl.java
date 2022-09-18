package com.github.fabriciolfj.providers;

import com.github.fabriciolfj.business.ProviderSaveProduct;
import com.github.fabriciolfj.entities.Product;
import com.github.fabriciolfj.exceptions.ProductSaveException;
import com.github.fabriciolfj.providers.repositories.ProductRepository;
import com.github.fabriciolfj.providers.repositories.converter.ProductDataConverter;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductProvidersImpl implements ProviderSaveProduct {

    private final ProductRepository repository;

    @Override
    @ReactiveTransactional
    public Uni<Void> process(Product product) {
        return repository.saveProduct(ProductDataConverter.toData(product))
                .onItem()
                .ifNull().failWith(new ProductSaveException())
                .onItem()
                .ifNotNull()
                .transformToUni(result -> Uni.createFrom().voidItem());
    }
}
