alter table DDCDIT_PRODUCT add constraint FK_DDCDIT_PRODUCT_ON_CATEGORY foreign key (CATEGORY_ID) references DDCDIT_PRODUCT_CATEGORY(ID);
create unique index IDX_DDCDIT_PRODUCT_UNIQ_PRODUCT_ID on DDCDIT_PRODUCT (PRODUCT_ID) ;
create index IDX_DDCDIT_PRODUCT_ON_CATEGORY on DDCDIT_PRODUCT (CATEGORY_ID);