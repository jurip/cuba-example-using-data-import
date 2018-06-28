alter table DDCDIT_BASEBALL_STRENGTH add column SCORE integer ^
update DDCDIT_BASEBALL_STRENGTH set SCORE = 0 where SCORE is null ;
alter table DDCDIT_BASEBALL_STRENGTH alter column SCORE set not null ;
