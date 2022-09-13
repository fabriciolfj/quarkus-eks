package com.github.fabriciolfj.business;

import com.github.fabriciolfj.entities.Product;
import io.smallrye.mutiny.Uni;

public interface ProviderSaveProduct {

    Uni<Void> process(final Product product);
}
