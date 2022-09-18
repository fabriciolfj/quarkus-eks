package com.github.fabriciolfj.providers.repositories;


import com.github.fabriciolfj.providers.repositories.data.ProductData;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements PanacheRepositoryBase<ProductData, Long> {

    public Uni<ProductData> saveProduct(final ProductData data) {
        return persist(data);
    }
}
