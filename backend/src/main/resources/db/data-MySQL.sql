INSERT INTO final_project.USER (id, password, username, name, lastname) VALUES
(1, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'user', 'Uno', 'DOS'),
(2, '{bcrypt}$2y$12$6C5T4j7HlR8CaokuYbtvMuKU5GAHJxVmq7v9oQonieq5jTAtEiRuG', 'admin', 'Mano', 'Pavarde');

INSERT INTO final_project.ROLE (id, role_name) VALUES
(1, 'USER'),
(2, 'ADMIN');

INSERT INTO final_project.USER_ROLES (user_id, role_id) VALUES
(1, 1),
(2, 2),
(2, 1);

INSERT INTO final_project.PRODUCT (id, is_active, name, price, description) VALUES
(1,1,'a',11.0,'aaaa');

INSERT INTO final_project.product_key(id, licence_key, product_id) VALUES
(1,'bbbb',1),
(2,'cccc',1);