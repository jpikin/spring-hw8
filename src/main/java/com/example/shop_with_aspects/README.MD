Запросы для Postman

GET: localhost:8099/ - список всех товаров

GET: localhost:8099/person - список всех покупателей

POST: localhost:8099/add - добавляем товар:

```
{
"name": "bike",
"price": 1000.00,
"mainStore": 10,
"reserveStore": 0
}
```

POST: localhost:8099/addPerson - добавляем покупателей:

```
{
    "name" : "John",
    "account": 10000
}
```

PUT: localhost:8099/reserve/1?quantity=1 - резервируем товар, 
где ?quantity= параметр количества, которое нужно забронировать.

POST: localhost:8099/buy/1/1 - совершаем покупку.  где /1/1 - id товара/покупателя