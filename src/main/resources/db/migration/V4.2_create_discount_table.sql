CREATE TABLE discount
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR,
    discount_code VARCHAR,
    discount_percentage NUMERIC(20, 2),
    valid_from TIMESTAMP,
    valid_to TIMESTAMP
);