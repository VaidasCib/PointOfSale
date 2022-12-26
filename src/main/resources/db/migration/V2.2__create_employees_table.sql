CREATE TABLE employees
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    salary NUMERIC(20, 2),
    on_holiday BOOLEAN,
    user_id UUID,
    role_id UUID
);

ALTER TABLE employees
    ADD CONSTRAINT fk_users_employees FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE employees
    ADD CONSTRAINT fk_roles_employees FOREIGN KEY (role_id) REFERENCES roles (id);