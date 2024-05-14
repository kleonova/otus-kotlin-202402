# MVP Sprint 1

Первая итерация включает в себя работу с сущностью "CustomerOrder", "RestaurantOrder", "CourierOrder".
Не включает изменение других сущностей, в том числе позиций заказа
Обеспечить MOCK данные других сущностей

[Жизненный цикл Заказа](../02-analytics/03-order-lifecycle.svg)

[Статусы Заказа](../02-analytics/04-order-statuses.svg)

## Функции
- Создать заказ POST /customer/order/create
- Отменить заказ PUT /customer/order/cancel
- Передать информацию об оплате PUT /customer/order/paid
- Обновить статус заказа PUT /customer/order/update
- Просмотр всех заказов GET /restaurant/{id}/orders
- Принять заказ PUT /restaurant/{id}/order/accept
- Отменить заказ PUT /restaurant/{id}/order/deny
- Собрать заказ PUT /restaurant/{id}/order/complete
- Принять заказ PUT /courier/order/accept
- Забрать заказ из ресторана PUT /courier/order/pickup
- Доставить заказ PUT /courier/order/complete
