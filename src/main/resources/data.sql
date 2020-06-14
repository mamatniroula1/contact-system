insert into users(username, password, email, enabled) values('sunil', '{noop}secret', 'sunilniroula1@gmail.com', true);
insert into users(username, password, email, enabled) values('user', '{noop}secret', 'sunilniroula1@gmail.com', true);
insert into users(username, password, email, enabled) values('admin', '{noop}secret', 'sunilniroula1@gmail.com', true);
insert into authorities values ('user', 'USER');
insert into authorities values ('admin', 'ADMIN');
insert into authorities values ('sunil', 'ADMIN');