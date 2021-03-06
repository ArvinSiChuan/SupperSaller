/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 12.0 		*/
/*  Created On : 30-5��-2017 16:23:08 				*/
/*  DBMS       : Oracle 						*/
/* ---------------------------------------------------- */

/* Drop Sequences */

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = 'C##PROMOTION' 
  AND SEQUENCE_NAME = 'SEQ_PAYMENT'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE seq_payment'; 
END IF; 
END; 
;

/* Create Sequences */

create sequence seq_payment
start with 1
increment by 1
maxvalue 9999999999999999
minvalue 1
cycle
cache 32 
;