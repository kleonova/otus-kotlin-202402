# API сервисa по доставке еды 

## Customer

### Описание сущности Клиент (Customer)
- id (идентификатор)
- phone (телефон, для связи курьера)
- email (почтовый адрес, для отправки чеков)
- discount (скидка клиента)

### Описание сущности Адрес доставки (CustomerAddress)
- id (идентификатор)
- address (физический адрес)
- coordinates (геолокация)
- description (для указания особенностей адреса, передавать для курьера)

### Описание сущности Заказ (CustomerOrders)
- id (идентификатор)
- status (статус заказа)
- price (итоговая цена)
- delivery_datetime (время доставки заказа)
- delivery_address (выбранный адрес доставки)
- timestamp (время создания заказа)
- mark (оценка)

### Описание сущности Позиции заказа (OrderItem)
- id (идентификатор)
- title
- price
- quantity (количество)
- description (Описание позиции, вес, КБЖУ)

### Функции
- Создать заказ POST /customer/order/create
- Отменить заказ PUT /customer/order/cancel
- Передать информацию об оплате PUT /customer/order/paid
- Обновить статус заказа PUT /customer/order/update
- CRUDS для сущности Позиции заказа (если ресторан не может приготовить блюдо, он должен иметь возможность его заменить)
- Посмотреть все заказы GET /customer/order
- CRUDS для сущности Адрес доставки
- Получить информацию по заказу для курьера GET /customer/order/{id}/info
- Поставить оценку PUT /customer/order/mark


## Restaurant
Единая сеть ресторанов, имеет общие позиции меню.
Для возможности масштабироваться - можно создать несколько филиалов.

У каждого филиала свой запас продуктов, 
в зависимости от наличия продуктов, некоторые блюда могут быть недоступны именно в этом филиале ресторана.

### Описание сущности Ресторан (Restaurant) 
- id (идентификатор)
- name (название)
- address (адрес ресторана, для формирования заказа курьеру)
- coordinates (геолокация)
- phone (телефон)
- status (статус работы ресторана: OPEN / CLOSE)

### Описание сущности Сотрудник (Employee)
- id (идентификатор)
- lastname (фамилия)
- firstname (имя)
- secondname (отчество)

### Описание сущности Заказ (RestaurantOrder)
- id
- status
- price (стоимость по кухне)
- timestamp (время создания заказа для ресторана!)
- lead_datetime (время передачи заказа курьеру)

### Описание сущности История заказа (OrderHistoryItem)
- id
- changed_field
- old_value
- new_value
- editor
- timestamp

### Описание сущности Позиция заказа (OrderItem)
- id
- status (WAIT, READY, PROGRESS)
- заказ
- позиция меню

### Описание сущности Позиция меню (MenuItem)
- id
- name
- image (ссылка на изображение)
- description
- base_price
- weight

### Описание сущности Позиция меню ресторана (RestaurantMenuItem)
- id
- cooking_time (время приготовления)
- status (ACTIVE, STOP)

### Описание сущности Ингридиент (Ingredient)
- id
- name
- energy_value
- proteins
- fats
- carbohydrates

### Описание сущности Склад (Stocks)
- id
- stock_quantity (остатки)
- Ingredient
- Restaurant

### Функции
- CRUDS для сущности Ресторан
- CRUDS для сущности Сотрудник
- CRUDS для сущности Позиция меню
- CRUDS для сущности Позиция меню ресторана
- CRUDS для сущности История заказа
- CRUDS для сущности Ингридиент
- CRUDS для сущности Склад
- Получить список ресторанов GET 
- Получить меню ресторана GET /restaurant/{id}/menu
- Просмотр всех заказов GET /restaurant/{id}/orders
- Принять заказ PUT /restaurant/{id}/order/accept
- Отменить заказ PUT /restaurant/{id}/order/deny
- Собрать заказ PUT /restaurant/{id}/order/complete


## Courier

### Описание сущности Курьер (Courier)
- id
- phone
- status
- coordinates

### Описание сущности Заказ (CourierOrder)
- id
- status
- delivery_price
- timestamp
- lead_datetime
- address_restaurant
- address_customer
- description

### Функции
- Обновить геолокацию курьера PUT /courier/{id}
- Найти доступных курьеров  GET /courier/couriers
- Просмотр всех заказов GET /courier/orders
- Принять заказ PUT /courier/order/accept
- Забрать заказ из ресторана PUT /courier/order/pickup
- Доставить заказ PUT /courier/order/complete