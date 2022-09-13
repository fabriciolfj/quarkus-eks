package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Product;
import io.smallrye.mutiny.Uni;

public interface ProviderFindProduct {

    Uni<Product> process(final String code);
}
