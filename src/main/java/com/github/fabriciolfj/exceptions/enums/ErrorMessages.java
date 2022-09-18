package com.github.fabriciolfj.exceptions.enums;

import java.util.ResourceBundle;

public enum ErrorMessages {

    SAVE_PRODUCT;

    public String toMessage() {
        var bundle = ResourceBundle.getBundle("exceptions.properties");
        return bundle.getString(this.toString() + ".message");
    }
}
