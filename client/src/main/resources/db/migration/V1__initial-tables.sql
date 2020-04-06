/* create table payment */
create table payment
(
	id bigint(20) auto_increment primary key,
	payment_id bigint(20) null,
	date_cr DATE null,
	filia_name varchar(255) null,
	filia_num bigint(20) null,
	full_lines int null,
	full_sum int null,
	mfo_filia bigint null,
	opfu_code bigint null,
	opfu_name varchar(255) null
) DEFAULT CHARSET=utf8;


