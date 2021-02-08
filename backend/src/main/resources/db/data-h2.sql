INSERT INTO USER (id, password, username, name, lastname)
VALUES (1, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'user', 'Uno', 'DOS'),
       (2, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'admin', 'Mano', 'Pavarde');

INSERT INTO ROLE (id, role_name)
VALUES (1, 'USER'),
       (2, 'ADMIN');

INSERT INTO USER_ROLES (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (2, 1);

INSERT INTO PRODUCT(id, description, is_active, flag,name, price)
VALUES (1, 'aaaa', 1, 'a', 10.00),
       (1, 'aaaa', 1, 'a', 10.00);