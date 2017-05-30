CREATE OR REPLACE PACKAGE discount_rule
AS
PROCEDURE get_Specific_rules(type in discount_rules.Rule_Type%type,rules out discount_rules%rowtype);

END discount_rule;


CREATE OR REPLACE PACKAGE BODY discount_rule
AS
PROCEDURE get_Specific_rules
	(type in discount_rules.Rule_Type%type,rules out discount_rules%rowtype)
AS
	-- get Buy Free Rules
BEGIN
	select * into rules from discount_rules where rule_type=type;
END get_Specific_rules; 
END discount_rule;

SHOW ERROR;