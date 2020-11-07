--DB Scripts

DROP TABLE IF EXISTS  ORDERDETAILS;
CREATE TABLE ORDERDETAILS ( 
order_id long primary key, 
order_status varchar(50) not null, 
order_customer_id long not null, 
shipping_method  varchar(50) not null,
payment_id long null,
billing_address_id  long null,
Shipping_address_id  long  null,
createtime  timestamp with time zone not null,
updatedtime timestamp with time zone not null,
created_by varchar(50) not null,
Modified_by varchar(50) not null
);


DROP TABLE IF EXISTS  ORDERITEMDETAILS;
CREATE TABLE ORDER_ITEM_DETAILS ( 
item_id long primary key, 
item_name varchar(50) not null,
order_id long  not null,
createtime  timestamp with time zone not null,
updatedtime timestamp with time zone not null,
created_by varchar(50) not null,
Modified_by varchar(50) not null
);



DROP TABLE IF EXISTS  ORDERPAYMENTDETAILS;
CREATE TABLE ORDERPAYMENTDETAILS ( 
payment_id long primary key, 
subtotal integer not null,
tax integer not null,
total integer not null,
payment_confirmation_number long not null,
payment_method varchar(50) not null,
payment_date  timestamp  not null,
transaction_id long null,
createtime  timestamp with time zone not null,
updatedtime timestamp with time zone not null,
created_by varchar(50) not null,
modified_by varchar(50) not null
);


DROP TABLE IF EXISTS  ORDERPAYMENTTRANSACTION;
CREATE TABLE ORDERPAYMENTTRANSACTION ( 
transaction_id long primary key, 
payment_id long null,
transaction_reference long null,
name_on_card varchar(50) not null,
card_number  smallint(16) not null,
expiry_date date not null,
cvv varchar(3),
deduction_amount integer not null,
createtime  timestamp with time zone not null,
updatedtime timestamp with time zone not null,
created_by varchar(50) not null,
modified_by varchar(50) not null
);

DROP TABLE IF EXISTS  ORDERBILLINGADDRESS;
CREATE TABLE ORDERBILLINGADDRESS ( 
billing_address_id  long primary key, 
billing_addressline1 varchar(300) not null,
billing_addressline2 varchar(300) not null,
billing_city varchar(50) not null,
billing_state varchar(50) not null,
billing_zip smallint(7) not null,
createtime  timestamp with time zone not null,
updatedtime timestamp with time zone not null,
created_by varchar(50) not null,
modified_by varchar(50) not null
);


DROP TABLE IF EXISTS  ORDERSHIPPINGADDRESS;
CREATE TABLE ORDERSHIPPINGADDRESS ( 
Shipping_address_id  long primary key, 
shipping_addressline1 varchar(300) not null,
shipping_addressline2 varchar(300) not null,
shipping_city varchar(50) not null,
shipping_state varchar(50) not null,
shipping_zip smallint(7) not null,
createtime  timestamp with time zone not null,
updatedtime timestamp with time zone not null,
created_by varchar(50) not null,
modified_by varchar(50) not null
);



--------------------------------------------------------------------------------------------------------------------------------------------------
-- adding constraints 

alter table ORDERDETAILS  add  constraint payment_id foreign key(payment_id) references ORDERPAYMENTDETAILS(payment_id);
alter table ORDERDETAILS  add  constraint billing_address_id foreign key(billing_address_id) references ORDERBILLINGADDRESS(billing_address_id);
alter table ORDERDETAILS  add  constraint Shipping_address_id foreign key(Shipping_address_id) references ORDERSHIPPINGADDRESS(Shipping_address_id);
alter table ORDERPAYMENTTRANSACTION  add  constraint payment_id foreign key(payment_id) references ORDERPAYMENTDETAILS(payment_id);





