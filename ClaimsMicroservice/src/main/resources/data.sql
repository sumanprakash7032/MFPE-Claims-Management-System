DROP TABLE IF EXISTS benefits;
create table benefits(benefit_id int, benefit_name varchar(50));

insert into benefits (benefit_id,benefit_name) values(201,'Free Monthly Health Checkup');
insert into benefits (benefit_id,benefit_name) values(202,'Cashless Medical Treatment');
insert into benefits (benefit_id,benefit_name) values(203,'Coverage For Covid-19 Treatment');
insert into benefits (benefit_id,benefit_name) values(204,'Daily Hospital Cash Benefit');
insert into benefits (benefit_id,benefit_name) values(205,'Tax Benefits On The Health Insurance Premium');

DROP TABLE IF EXISTS provider_policy;
create table provider_policy(provider_id int,provider_name varchar(20),provider_address varchar(50),policy_id int,location varchar(20));

/*Inserting data in provider_policy table*/
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(1,'MG Road','City Hospital',1,'Chennai');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(2,'Chitnis Nagar','LIC',1,'Nagpur');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(3,'Chandni Chowk','Bajaj',2,'Delhi');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(4,'Dhayari','Apollo Hospital',3,'Pune');
insert into provider_policy (provider_id,provider_address,provider_name,policy_id,location) values(5,'Boriwali','HDFC',2,'Mumbai');


DROP TABLE IF EXISTS claim;
create table claim(claim_id int,amount_claimed double,amount_settled double,benefit_id int,claim_status varchar(20),member_id int,policy_id int,provider_id int,description varchar(255));
/* inserting in claim*/
insert into claim (claim_id,amount_claimed,amount_settled,benefit_id,claim_status,member_id,policy_id,provider_id,description) values(1,50000.0,50000.0,202,'claimed',1,3,3,'Acccident claim on City Hospital');
insert into claim (claim_id,amount_claimed,amount_settled,benefit_id,claim_status,member_id,policy_id,provider_id,description) values(2,42000.0,42000.0,205,'claimed',2,1,4,'claim on LIC');
insert into claim (claim_id,amount_claimed,amount_settled,benefit_id,claim_status,member_id,policy_id,provider_id,description) values(3,90000.0,50000.0,201,'not claimed',2,2,1,'Hdfc Claim');

/*insert into member_claim (policy_id,member_id,claim_id,provider_id,benefit_id,total_billed_amount,total_claimed_amount,claim_status,claim_description) values(1,2,3,4,203,42000.0,42000.0,'claimed','LIC claim');
insert into member_claim (policy_id,member_id,claim_id,provider_id,benefit_id,total_billed_amount,total_claimed_amount,claim_status,claim_description) values(2,2,2,1,203,90000.0,0.0,'not claimed','HDFC claim');*/
