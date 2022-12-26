CREATE TABLE shifts
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    shift_date TIMESTAMP,
    shift_start TIMESTAMP,
    shift_end TIMESTAMP,
    week_day VARCHAR,
    state_holiday BOOLEAN
);

CREATE TABLE employee_shifts
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    employee_id UUID,
    shift_id UUID
);

ALTER TABLE employee_shifts
    ADD CONSTRAINT fk_employee_employee_shifts FOREIGN KEY (employee_id) REFERENCES employees (id);

ALTER TABLE employee_shifts
    ADD CONSTRAINT fk_shift_employee_shifts FOREIGN KEY (shift_id) REFERENCES shifts (id);