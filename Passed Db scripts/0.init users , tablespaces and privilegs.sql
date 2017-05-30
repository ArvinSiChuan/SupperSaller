-- create user
create user C##Promotion identified by arvinsichuan;

-- create tablespace
create tablespace promotion
	datafile 'C:\oracle\DB FILE\promotion.dat' size 50M
	autoextend on next 5M;
-- grant tablespace to user
alter user c##promotion default tablespace promotion;
alter user C##PROMOTION quota unlimited on promotion;

-- granting privilegs
grant 
	create session, 
	create tablespace,
	alter any index,
	alter any table,
	alter any sequence,
	alter any trigger,
	create any index,
	create any procedure,
	create any table,
	backup any table,
	alter any procedure,
	create any sequence,
	create any trigger,
	create any view,
	create rollback segment,
	drop any index,
	drop any procedure,
	drop any table,
	drop any view,
	drop any trigger,
	insert any table,
	update any table,
	delete any table ,
	select any table
to
	c##promotion;


