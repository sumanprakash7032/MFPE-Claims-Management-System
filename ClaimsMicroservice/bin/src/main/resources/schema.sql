create table claim (
claim_id int primary key,
claim_status varchar(15),
description varchar(250),
policy_id int ,
member_id int,
benefit_id int,
provider_id int,
amount_claimed double,
amount_settled double
);