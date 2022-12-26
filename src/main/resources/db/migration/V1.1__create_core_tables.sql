CREATE TABLE merchants
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR,
    company_code VARCHAR,
    location VARCHAR,
    contact_phone VARCHAR,
    contact_email VARCHAR
);

CREATE TABLE users
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR,
    surname VARCHAR,
    date_of_birth TIMESTAMP,
    password VARCHAR,
    merchant_id UUID
);