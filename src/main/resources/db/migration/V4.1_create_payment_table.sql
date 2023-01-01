CREATE TABLE payment
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    payment_type VARCHAR,
    payment_status VARCHAR,
    total NUMERIC(20, 2),
    tax VARCHAR,
    paid_time TIMESTAMP
);