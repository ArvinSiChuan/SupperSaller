/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 12.0 		*/
/*  Created On : 30-05-2017 16:23:08 				*/
/*  DBMS       : Oracle 						*/
/*  Grammer Checked and Tested        */
/* ---------------------------------------------------- */

/* Drop Tables */
DECLARE
  C NUMBER;
BEGIN
SELECT COUNT(*) INTO C
FROM USER_TABLES
  WHERE TABLE_NAME = 'SALED_GOODS' ;
  IF (C > 0) THEN
    EXECUTE IMMEDIATE 'DROP TABLE SALED_GOODS CASCADE CONSTRAINTS';
END IF;
END;


/* Create Tables */

CREATE TABLE Saled_Goods
(
	Good_ID VARCHAR2(64) NOT NULL,
	Sum NUMBER(8,2) NOT NULL,
	SALED_DATE DATE NOT NULL,
	Price NUMBER(9,2) NOT NULL,
	Order_ID CHAR(32) NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks, Triggers */

CREATE INDEX IXFK_Order_has_many_Goods01
 ON Saled_Goods (Order_ID)
;

ALTER TABLE Saled_Goods
 ADD CONSTRAINT PK_Saled_Goods
	PRIMARY KEY (Good_ID,Order_ID) USING INDEX
;

/* Create Foreign Key Constraints */

ALTER TABLE Saled_Goods
 ADD CONSTRAINT FK_Order_has_many_Goods
	FOREIGN KEY (Order_ID) REFERENCES Orders (Order_ID) ON DELETE CASCADE
;
