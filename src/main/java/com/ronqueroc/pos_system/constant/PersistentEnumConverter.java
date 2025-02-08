package com.ronqueroc.pos_system.constant;

import jakarta.persistence.AttributeConverter;

public class PersistentEnumConverter<T extends Enum<T> & PersistentEnum> implements AttributeConverter<T, String> {
    private final Class<T> clazz;

    public PersistentEnumConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public String convertToDatabaseColumn(T theEnum) {
        return theEnum != null ? theEnum.getValue() : null;
    }

    @Override
    public T convertToEntityAttribute(String dbValue) {
        T[] enums = clazz.getEnumConstants();
        for (T theEnum : enums) {
            if (theEnum.getValue().equals(dbValue)) {
                return theEnum;
            }
        }
        return null;
    }
}
