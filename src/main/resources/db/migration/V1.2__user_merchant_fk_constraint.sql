ALTER TABLE users
    ADD CONSTRAINT fk_merchants_users FOREIGN KEY (merchant_id) REFERENCES merchants (id);