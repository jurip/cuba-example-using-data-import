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
);
