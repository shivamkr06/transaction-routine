CREATE TABLE IF NOT EXISTS account (
    account_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    document_number VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS operation_type (
    operation_type_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS transaction (
    transaction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id BIGINT,
    operation_type_id BIGINT,
    amount DOUBLE,
    event_date TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account(account_id),
    FOREIGN KEY (operation_type_id) REFERENCES operation_type(operation_type_id)
);

INSERT INTO account (document_number) VALUES ('12345678900');

INSERT INTO operation_type (description) VALUES ('Normal Purchase');
INSERT INTO operation_type (description) VALUES ('Purchase with installments');
INSERT INTO operation_type (description) VALUES ('Withdrawal');
INSERT INTO operation_type (description) VALUES ('Credit Voucher');

INSERT INTO transaction (account_id, operation_type_id, amount, event_date) VALUES (1, 1, -50.0, '2020-01-01T10:32:07.7199222');
INSERT INTO transaction (account_id, operation_type_id, amount, event_date) VALUES (1, 1, -23.5, '2020-01-01T10:48:12.2135875');
INSERT INTO transaction (account_id, operation_type_id, amount, event_date) VALUES (1, 1, -18.7, '2020-01-02T19:01:23.1458543');
INSERT INTO transaction (account_id, operation_type_id, amount, event_date) VALUES (1, 4, 60.0, '2020-01-05T09:34:18.5893223');
