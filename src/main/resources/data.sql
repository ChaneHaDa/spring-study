insert into customer
(name,email,password)
values('admin','example@do.com','1234');

insert into authority
(name, customer_id)
VALUES ('ADMIN', 1);