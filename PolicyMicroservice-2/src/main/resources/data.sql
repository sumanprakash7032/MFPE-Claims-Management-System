DROP TABLE IF EXISTS benefits;
create table benefits(benefit_id int, benefit_name varchar(50));

insert into benefits (benefit_id,benefit_name) values(201,'Free Monthly Health Checkup');
insert into benefits (benefit_id,benefit_name) values(202,'Cashless Medical Treatment');
insert into benefits (benefit_id,benefit_name) values(203,'Coverage For Covid-19 Treatment');
insert into benefits (benefit_id,benefit_name) values(204,'Daily Hospital Cash Benefit');
insert into benefits (benefit_id,benefit_name) values(205,'Tax Benefits On The Health Insurance Premium');

DROP TABLE IF EXISTS policy;
create table policy(policy_id int,benefit_id int,cap_amount_benefits double,policy_number int,premium double,tenure int);

insert into policy (policy_id,benefit_id,cap_amount_benefits,policy_number,premium,tenure) values(1,201,120000.0,101,2000.0,25);
insert into policy (policy_id,benefit_id,cap_amount_benefits,policy_number,premium,tenure) values(2,203,80000.0,102,8000.0,21);
insert into policy (policy_id,benefit_id,cap_amount_benefits,policy_number,premium,tenure) values(3,203,30000.0,103,3000.0,14);


DROP TABLE IF EXISTS member_policy;
create table member_policy(member_id int,policy_id int,policy_number int,benefit_id int,subscription_date date,tenure int,cap_amount_benefits double);

insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(1,1,101,202,'2021-06-24',21,100000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(2,1,101,201,'2020-03-07',21,120000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(3,2,102,203,'2019-01-09',14,80000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(2,1,102,201,'2019-01-09',14,80000.00);
insert into member_policy (member_id,policy_id,policy_number,benefit_id,subscription_date,tenure,cap_amount_benefits) values(1,3,102,201,'2019-01-09',14,80000.00);

DROP TABLE IF EXISTS provider_policy;
create table provider_policy(provider_id int,provider_name varchar(20),provider_address varchar(50),policy_id int,location varchar(20));

/*Inserting data in provider_policy table*/
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(1,'MG Road','City Hospital',2,'Chennai');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(2,'Chitnis Nagar','LIC',1,'Nagpur');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(3,'Chandni Chowk','Bajaj',3,'Delhi');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(4,'Dhayari','Apollo Hospital',1,'Pune');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(5,'Boriwali','HDFC',2,'Mumbai');

/*insert into provider_policy values(100,'Guntur',10001,'Lalitha Super Speciality Hospitals');
insert into provider_policy values(101,'Guntur',10002,'Lalitha Multi Speciality Hospitals');
insert into provider_policy values(102,'Trichy',10001,'Apollo Hospitals');*/