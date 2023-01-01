CREATE TABLE taxes
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tax NUMERIC(20, 2),
    name VARCHAR
);