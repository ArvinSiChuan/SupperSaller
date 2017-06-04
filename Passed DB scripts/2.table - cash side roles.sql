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
  WHERE TABLE_NAME = 'CASH_SIDE_ROLES' ;
  IF (C > 0) THEN
    EXECUTE IMMEDIATE 'DROP TABLE CASH_SIDE_ROLES CASCADE CONSTRAINTS';
END IF;
END;



/* Create Tables */

CREATE TABLE Cash_Side_Roles
(
	Em_Role VARCHAR2(64) NOT NULL,
	Em_ID VARCHAR2(64) NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks, Triggers */

ALTER TABLE Cash_Side_Roles
 ADD CONSTRAINT PK_Cash_Side_Roles
	PRIMARY KEY (Em_Role,Em_ID) USING INDEX
;

/* Create Foreign Key Constraints */

ALTER TABLE Cash_Side_Roles
 ADD CONSTRAINT FK_Em_play_Roles
	FOREIGN KEY (Em_ID) REFERENCES Cash_Side_Employees(Em_ID) ON DELETE Cascade
;

INSERT INTO CASH_SIDE_ROLES
(em_role,em_id)
values
('Deleted','________');
