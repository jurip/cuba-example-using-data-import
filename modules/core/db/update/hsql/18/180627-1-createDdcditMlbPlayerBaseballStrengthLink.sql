create table DDCDIT_MLB_PLAYER_BASEBALL_STRENGTH_LINK (
    BASEBALL_STRENGTH_ID varchar(36) not null,
    MLB_PLAYER_ID varchar(36) not null,
    primary key (BASEBALL_STRENGTH_ID, MLB_PLAYER_ID)
);
