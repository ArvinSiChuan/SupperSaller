CREATE OR REPLACE PACKAGE discount_rule
AS
TYPE rule_ref_cursor IS REF CURSOR;
PROCEDURE get_Specific_rules(type in discount_rules.Rule_Type%type,rules out rule_ref_cursor);

END discount_rule;


CREATE OR REPLACE PACKAGE BODY discount_rule
AS
PROCEDURE get_Specific_rules
	(type in discount_rules.Rule_Type%type,rules out rule_ref_cursor)
AS
	-- get Buy Free Rules
BEGIN
    OPEN RULES FOR
	select * from discount_rules where rule_type=type;
END get_Specific_rules; 
END discount_rule;

SHOW ERROR;