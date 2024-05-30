package com.example.shop_with_aspects.exeptions;

public class NotEnoughQuantityException extends Exception{
    public NotEnoughQuantityException() {
        super("Недостаточное количество для списания");
    }

}
