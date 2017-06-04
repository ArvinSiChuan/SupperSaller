-- create user
/*
	ATTENTION:
			Change passcode if NECCESARY!
			Passcode should be the same as the programming side.
*/
create user C##Promotion identified by arvinsichuan;

-- create tablespace
/* ATTENTION:
			Please create the dir:'C:\oracle\DB FILE\'
			or change the datafile uri to your customized directory.
*/
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
	create any index,
	create any procedure,
	create any table,
	create any sequence,
	create any trigger,
	create any view,
	create rollback segment,
	alter any index,
	alter any table,
	alter any sequence,
	alter any trigger,
	alter any procedure,
	backup any table,
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
