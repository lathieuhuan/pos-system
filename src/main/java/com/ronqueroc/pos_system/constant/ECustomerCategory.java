package com.ronqueroc.pos_system.constant;

import java.util.HashMap;
import java.util.Map;

public enum ECustomerCategory implements PersistentEnum {
    WALKIN("WALKIN", "Walk-in"),
    MEMBER("MEMBER", "Member");

    private static final Map<String, ECustomerCategory> mapByValue = new HashMap<>();

    static {
        for (ECustomerCategory e : values()) {
            mapByValue.put(e.getValue(), e);
        }
    }

    ECustomerCategory(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    private final String value;

    private final String displayName;

    @Override
    public String getValue() {
        return this.value;
    }

    public static ECustomerCategory from(String value) {
        return mapByValue.get(value);
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    public static class Converter extends PersistentEnumConverter<ECustomerCategory> {
        public Converter() {
            super(ECustomerCategory.class);
        }
    }
}
