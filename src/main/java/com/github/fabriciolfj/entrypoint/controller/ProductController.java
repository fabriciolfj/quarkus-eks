package com.github.fabriciolfj.entrypoint.controller;

import com.github.fabriciolfj.business.usecase.SaveProduct;
import com.github.fabriciolfj.entrypoint.converter.ProductDTOConverter;
import com.github.fabriciolfj.entrypoint.dto.request.ProductRequest;
import com.github.fabriciolfj.entrypoint.dto.response.ProductResponse;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/api/v1/products")
@Produces("application/json")
@Consumes("application/json")
@RequiredArgsConstructor
public class ProductController {

    private final SaveProduct saveProduct;

    @POST
    public Uni<Response> create(final Uni<ProductRequest> requestUni) {
        return requestUni
                .onItem()
                .transform(r -> ProductDTOConverter.toEntity(r))
                .onItem()
                .transformToUni(p -> saveProduct.execute(p))
                .onItem()
                .transform(result -> Response
                        .status(Response.Status.CREATED)
                        .entity(new ProductResponse(result))
                        .build())
                .onFailure()
                .recoverWithItem(r -> Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new Error(r.getMessage()))
                        .build());
    }
}
