INSERT INTO users(username,password,enabled)
VALUES ('admin','{noop}admin', true);

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_USER');

INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');
