package com.xxavierr404.dreambuildr.misc.exceptions;

import com.xxavierr404.dreambuildr.misc.enums.CompatibilityType;

public class ConfigurationIsIncompatibleException extends RuntimeException {
    private final CompatibilityType error;

    public ConfigurationIsIncompatibleException(CompatibilityType error) {
        this.error = error;
    }

    public CompatibilityType getError() { return error; }
}
