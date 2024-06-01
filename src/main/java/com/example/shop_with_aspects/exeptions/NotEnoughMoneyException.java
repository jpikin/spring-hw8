package com.example.shop_with_aspects.exeptions;

public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException() {
        super("Недостаточное денег для оплаты товара");
    }

}
