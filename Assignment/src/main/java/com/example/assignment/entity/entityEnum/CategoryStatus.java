package com.example.assignment.entity.entityEnum;

public enum CategoryStatus {
    ACTIVE(1),
    DEACTIVE(0),
    DELETED(-1),
    UNDEFINED(-2);

    private int value;

    CategoryStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CategoryStatus of(int value) {
        for (CategoryStatus categoryStatus : CategoryStatus.values()) {
            if (categoryStatus.getValue() == value) {
                return categoryStatus;
            }
        }
        return CategoryStatus.UNDEFINED;
    }
}
