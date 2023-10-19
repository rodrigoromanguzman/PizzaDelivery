create table if not exist Pizza_Order(
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(10) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(50) not null,
    cc_expiration varchar(50) not null,
    cc_cvv varchar(50) not null,
    placed_at timestamp not null,
)

create table if not exists Pizza(
    id identity,
    name varchar(50) not null,
    pizza_order bigint not null,
    pizza_order_key bigint not null,
    created_at timestamp not null
)

create table if not exists Ingredient(
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
)

create table if not exist Ingredient_Ref(
    ingredient varchar(4) not null,
    pizza bigint not null,
    pizza_key bigint not null
)

alter table Pizza add foreign Key(pizza_order) reference Pizza_Order(id);
add foreign Key(Ingredient) referecnes ingredient(id);