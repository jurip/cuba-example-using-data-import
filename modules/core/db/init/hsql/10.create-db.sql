-- begin DDCDIT_CUSTOMER
create table DDCDIT_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PRIORITY integer,
    FIRST_NAME varchar(255),
    DOCUMENT_NUMBER varchar(50) not null,
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end DDCDIT_CUSTOMER
-- begin DDCDIT_ORDER
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
)^
-- end DDCDIT_ORDER
-- begin DDCDIT_MLB_PLAYER
create table DDCDIT_MLB_PLAYER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TEAM_ID varchar(36),
    HEIGHT integer,
    WEIGHT integer,
    AGE double precision,
    BIRTHDAY date,
    LEFT_HANDED boolean,
    ANNUAL_SALARY decimal(19, 2),
    SPONSOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end DDCDIT_MLB_PLAYER
-- begin DDCDIT_MLB_TEAM
create table DDCDIT_MLB_TEAM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    STATE varchar(50),
    CODE varchar(255) not null,
    TELEPHONE integer,
    --
    primary key (ID)
)^
-- end DDCDIT_MLB_TEAM
-- begin DDCDIT_PRODUCT
create table DDCDIT_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID varchar(255) not null,
    NAME varchar(255) not null,
    CATEGORY_ID varchar(36),
    --
    primary key (ID)
)^
-- end DDCDIT_PRODUCT
-- begin DDCDIT_PRODUCT_CATEGORY
create table DDCDIT_PRODUCT_CATEGORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    PARENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end DDCDIT_PRODUCT_CATEGORY
-- begin DDCDIT_BASEBALL_STRENGTH
create table DDCDIT_BASEBALL_STRENGTH (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    SCORE integer not null,
    --
    primary key (ID)
)^
-- end DDCDIT_BASEBALL_STRENGTH
-- begin DDCDIT_MLB_PLAYER_BASEBALL_STRENGTH_LINK
create table DDCDIT_MLB_PLAYER_BASEBALL_STRENGTH_LINK (
    BASEBALL_STRENGTH_ID varchar(36) not null,
    MLB_PLAYER_ID varchar(36) not null,
    primary key (BASEBALL_STRENGTH_ID, MLB_PLAYER_ID)
)^
-- end DDCDIT_MLB_PLAYER_BASEBALL_STRENGTH_LINK
-- begin DDCDIT_MLB_PLAYER_SPONSOR
create table DDCDIT_MLB_PLAYER_SPONSOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SPONSOR_NAME varchar(255),
    SPONSORED_PLAYERS_FILE_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end DDCDIT_MLB_PLAYER_SPONSOR
-- begin DDCDIT_DATATYPE_EXAMPLE
create table DDCDIT_DATATYPE_EXAMPLE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LOCAL_DATE_TIME timestamp,
    STRING_TYPE varchar(255),
    --
    primary key (ID)
)^
-- end DDCDIT_DATATYPE_EXAMPLE
