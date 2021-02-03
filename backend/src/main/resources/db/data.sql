INSERT INTO USER (id, password, username, name, lastname) VALUES
(1, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'user', 'Vardenis', 'Pavardenis'),
(2, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'admin', 'Adminas', 'Adminauskas');

INSERT INTO ROLE (id, role_name) VALUES
(1, 'USER'),
(2, 'ADMIN');

INSERT INTO USER_ROLES (user_id, role_id) VALUES
(1, 1),
(2, 2),
(2, 1);

INSERT INTO PRODUCT (id, is_active, name, price, description) VALUES
(1,1,'a',11.0,'aaaa');

INSERT INTO product_key(id, licence_key, product_id) VALUES
(1,'bbbb',1),
(2,'cccc',1);