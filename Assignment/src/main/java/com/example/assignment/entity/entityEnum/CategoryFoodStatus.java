package com.example.assignment.entity.entityEnum;

public enum CategoryFoodStatus {
    ON_SALE(1),
    STOP_SELLING(2),
    DELETED(0),
    UNDEFINED(-1);
    private int value;

    CategoryFoodStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static CategoryFoodStatus of(int value) {
        for (CategoryFoodStatus categoryFoodStatus : CategoryFoodStatus.values()) {
            if(categoryFoodStatus.getValue() == value) {
                return categoryFoodStatus;
            }
        }
        return CategoryFoodStatus.UNDEFINED;
    }
}
