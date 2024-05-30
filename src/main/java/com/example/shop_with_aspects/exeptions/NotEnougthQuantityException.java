package com.example.shop_with_aspects.exeptions;

public class NotEnougthQuantityException extends Exception{
    public NotEnougthQuantityException() {
        super("Недостаточное количество для списания");
    }

}
