INSERT INTO `ROLLINGSTONE_USER`
(
`first_name`,
`last_name`,
`member_type`,
`registration_date`,
`sex`,
`user_name`,
`account_number`)
VALUES
(
'Binit',
'Datta',
'G',
'2015-01-01',
'M',
'bdatta',
'10001');

INSERT INTO `rollingstone_account`
(
`user_profile_id`,
`account_number`,
`account_name`)
VALUES
(
1,
'1001',
'Binit Datta');

INSERT INTO `rollingstone_address`
(
`city`,
`house_number`,
`state`,
`street_address`,
`zip_code`,
`account_id`)
VALUES
(
'Chicago',
'2345',
'IL',
'Main Street',
'60601',
1);
