/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 12.0 		*/
/*  Created On : 30-5��-2017 16:23:08 				*/
/*  DBMS       : Oracle 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_TABLES
  WHERE TABLE_NAME = 'RULES_ORDERS' ;
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TABLE RULES_ORDERS CASCADE CONSTRAINTS'; 
END IF; 
END; 

/* Create Tables */

CREATE TABLE Rules_Orders
(
	Rule_UUID CHAR(32) NOT NULL,
	Order_ID CHAR(32) NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks, Triggers */

CREATE INDEX IXFK_Rules_Orders_Discoun01  
 ON Rules_Orders (Rule_UUID) 
;

ALTER TABLE Rules_Orders 
 ADD CONSTRAINT PK_Rules_Orders
	PRIMARY KEY (Rule_UUID,Order_ID) USING INDEX
;

/* Create Foreign Key Constraints */

ALTER TABLE Rules_Orders 
 ADD CONSTRAINT FK_Rules_Orders_Discount_Rules
	FOREIGN KEY (Rule_UUID) REFERENCES Discount_Rules (Rule_UUID)
;

ALTER TABLE Rules_Orders 
 ADD CONSTRAINT FK_Orders_Rules_Orders
	FOREIGN KEY (Order_ID) REFERENCES Orders (Order_ID)
;