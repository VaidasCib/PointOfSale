CREATE TABLE services
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR,
    description VARCHAR,
    category_id UUID,
    price NUMERIC(20, 2),
    merchant_id UUID
);

CREATE TABLE timeslots
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    status VARCHAR,
    slot_form TIMESTAMP,
    slot_to TIMESTAMP,
    location VARCHAR,
    service_id UUID
);

CREATE TABLE employee_timeslots
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    employee_id UUID,
    timeslot_id UUID
);

ALTER TABLE employee_timeslots
    ADD CONSTRAINT fk_employee_employee_timeslots FOREIGN KEY (employee_id) REFERENCES employees (id);

ALTER TABLE employee_timeslots
    ADD CONSTRAINT fk_timeslot_employee_timeslots FOREIGN KEY (timeslot_id) REFERENCES timeslots (id);


CREATE TABLE tax_services
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tax_id UUID,
    service_id UUID
);

-- ALTER TABLE tax_services
--     ADD CONSTRAINT fk_tax_tax_services FOREIGN KEY (tax_id) REFERENCES taxes (id);

ALTER TABLE tax_services
    ADD CONSTRAINT fk_service_tax_services FOREIGN KEY (service_id) REFERENCES services (id);

CREATE TABLE arrangements
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    payment_id UUID,
    arrangement_owner_id UUID,
    tips NUMERIC(20, 2),
    specifications VARCHAR
);




CREATE TABLE employee_arrangements
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    employee_id UUID,
    arrangement_id UUID
);

ALTER TABLE employee_arrangements
    ADD CONSTRAINT fk_employee_employee_arrangements FOREIGN KEY (employee_id) REFERENCES employees (id);

ALTER TABLE employee_arrangements
    ADD CONSTRAINT fk_arrangement_employee_arrangements FOREIGN KEY (arrangement_id) REFERENCES arrangements (id);




CREATE TABLE discount_arrangements
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    discount_id UUID,
    arrangement_id UUID
);

-- ALTER TABLE discount_arrangements
--     ADD CONSTRAINT fk_discount_discount_arrangements FOREIGN KEY (discount_id) REFERENCES discounts (id);

ALTER TABLE discount_arrangements
    ADD CONSTRAINT fk_arrangement_discount_arrangements FOREIGN KEY (arrangement_id) REFERENCES arrangements (id);




CREATE TABLE timeslot_arrangements
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    timeslot_id UUID,
    arrangement_id UUID
);

ALTER TABLE timeslot_arrangements
    ADD CONSTRAINT fk_timeslot_timeslot_arrangements FOREIGN KEY (timeslot_id) REFERENCES timeslots (id);

ALTER TABLE timeslot_arrangements
    ADD CONSTRAINT fk_arrangement_timeslot_arrangements FOREIGN KEY (arrangement_id) REFERENCES arrangements (id);