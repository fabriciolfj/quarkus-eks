package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Product;
import io.smallrye.mutiny.Multi;

public interface ProviderFindProductsCategory {

    Multi<Product> process(final String category);
}
