package com.ronqueroc.pos_system.constant;

import java.util.HashMap;
import java.util.Map;

public enum EOrderStatus implements PersistentEnum {
    PROCESSING("PROCESSING", "Processing"),
    PROCESSED("PROCESSED", "Processed");

    private static final Map<String, EOrderStatus> mapByValue = new HashMap<>();

    static {
        for (EOrderStatus e : values()) {
            mapByValue.put(e.getValue(), e);
        }
    }

    EOrderStatus(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    private final String value;

    private final String displayName;

    @Override
    public String getValue() {
        return this.value;
    }

    public static EOrderStatus from(String value) {
        return mapByValue.get(value);
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    public static class Converter extends PersistentEnumConverter<EOrderStatus> {
        public Converter() {
            super(EOrderStatus.class);
        }
    }
}
