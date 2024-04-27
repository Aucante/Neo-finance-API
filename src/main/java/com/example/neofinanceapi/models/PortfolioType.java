package com.example.neofinanceapi.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PortfolioType {
    STOCK("STOCK"),
    BOND("BOND"),
    MUTUAL_FUND("MUTUAL_FUND"),
    ETF("ETF"),
    CRYPTO("CRYPTO"),
    OTHER("OTHER");

    private final String value;

    PortfolioType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
