create table DDCDIT_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(255) not null,
    ORDER_DATE date not null,
    SHIPPING_DATE date,
    SHIPPING_MODE integer,
    CUSTOMER_ID varchar(36) not null,
    PRODUCT_ID varchar(36) not null,
    PRICE decimal(19, 2),
    QUANTITY double precision,
    TOTAL_PRICE decimal(19, 2),
    --
    primary key (ID)
);
