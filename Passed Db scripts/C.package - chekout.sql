CREATE OR REPLACE PACKAGE checkout
is
PROCEDURE create_order(em in orders.EM_ID%TYPE,uuid out orders.Order_ID%type);
PROCEDURE add_good_to_order(good in saled_goods%rowtype);
PROCEDURE remove_good_from_order(id in saled_goods.Good_ID%type,oid in saled_goods.Order_ID%type);
PROCEDURE create_payment
	(sum in payments.Payment_Sum%type,
	channel_id in payments.PAYMENT_CHANNELSIDE_ID%type,
	channel in payments.Payment_Channel%type,
	em in payments.EM_ID%type,
	order_id in orders.Order_ID%type,
	id out payments.Payment_ID%type);
end checkout;


CREATE OR REPLACE PACKAGE BODY checkout
as
PROCEDURE create_order
	(em in orders.EM_ID%TYPE,uuid out orders.Order_ID%type)
AS
	-- create an order
BEGIN
	select 
	to_char(sysdate,'YYYYMMDDHH24MISS')||to_char(seq_order.nextval,'fm000000000000000000') 
	into uuid
	from dual;
	insert into orders 
	(order_id,order_sum,sum_money,order_status,em_id) 
	values 
	(uuid,0,0,'inited',em);
END create_order; 


PROCEDURE add_good_to_order
	(good in saled_goods%rowtype)
AS
	-- import goods
BEGIN
	insert into saled_goods
	(good_id,saled_date,sum,price,order_id) 
	values 
	(good.good_id,good.saled_date,good.sum,good.price,good.order_id);
END add_good_to_order; 

PROCEDURE remove_good_from_order
	(id in saled_goods.Good_ID%type,oid in saled_goods.Order_ID%type)
AS
	-- import goods
BEGIN
	delete from saled_goods where good_id = id and order_id = oid;
END remove_good_from_order; 

PROCEDURE create_payment
	(sum in payments.Payment_Sum%type,
	channel_id in payments.PAYMENT_CHANNELSIDE_ID%type,
	channel in payments.Payment_Channel%type,
	em in payments.EM_ID%type,
	order_id in orders.Order_ID%type,
	id out payments.Payment_ID%type)
AS
	-- create new payment
BEGIN
	select 
	to_char(sysdate,'YYYYMMDDHH24MISS')||to_char(seq_payment.nextval,'fm000000000000000000') 
	into id
	from dual;
	insert into payments 
	(payment_id,payment_sum,PAYMENT_CHANNELSIDE_ID,payment_channel,em_id)
	values
	(id,sum,channel_id,channel,em);
	update orders
	set payment_id=id
	where order_id=order_id;	
END; 

end checkout;

show error;