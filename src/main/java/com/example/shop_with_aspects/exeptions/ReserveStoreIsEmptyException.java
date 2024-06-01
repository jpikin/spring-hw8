package com.example.shop_with_aspects.exeptions;

public class ReserveStoreIsEmptyException extends Exception {
    public ReserveStoreIsEmptyException() {
        super("Товар не зарезервирован");
    }
}
