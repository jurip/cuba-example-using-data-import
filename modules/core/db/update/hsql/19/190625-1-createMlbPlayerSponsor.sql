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
);