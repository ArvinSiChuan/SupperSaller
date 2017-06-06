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
  WHERE TABLE_NAME = 'RULES_SALED_GOODS' ;
  IF (C > 0) THEN
    EXECUTE IMMEDIATE 'DROP TABLE RULES_SALED_GOODS CASCADE CONSTRAINTS';
END IF;
END;

/* Create Tables */

CREATE TABLE RULES_SALED_GOODS
(
	GOOD_ID VARCHAR2(32) NOT NULL,
	Order_id char(32) NOT NULL,
	RULE_UUID CHAR(32) NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks, Triggers */

CREATE INDEX IXFK_Rules_SALED_GOODS_RULE
 ON RULES_SALED_GOODS(Rule_UUID)
;

ALTER TABLE RULES_SALED_GOODS
 ADD CONSTRAINT PK_RULES_SALED_GOODS
	PRIMARY KEY (GOOD_ID,ORDER_ID,Rule_UUID) USING INDEX
;

/* Create Foreign Key Constraints */

ALTER TABLE RULES_SALED_GOODS
 ADD CONSTRAINT FK_RULES_SALED_GOODS_RULE
	FOREIGN KEY (Rule_UUID) REFERENCES Discount_Rules (Rule_UUID)
;

ALTER TABLE RULES_SALED_GOODS
 ADD CONSTRAINT FK_RULES_SALED_GOODS_GOOD
	FOREIGN KEY (GOOD_ID,ORDER_ID) REFERENCES SALED_GOODS(GOOD_ID,ORDER_ID)
;






