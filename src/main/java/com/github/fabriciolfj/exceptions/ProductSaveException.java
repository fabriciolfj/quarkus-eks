package com.github.fabriciolfj.exceptions;

import com.github.fabriciolfj.exceptions.enums.ErrorMessages;

public class ProductSaveException extends RuntimeException {

    public ProductSaveException() {
        super(ErrorMessages.SAVE_PRODUCT.toMessage());
    }
}
