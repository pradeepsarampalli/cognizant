INSERT INTO department (id, name) VALUES (1, 'Engineering');
INSERT INTO department (id, name) VALUES (2, 'Human Resources');
INSERT INTO department (id, name) VALUES (3, 'Finance');
ALTER TABLE department ALTER COLUMN id RESTART WITH 4;

INSERT INTO employee (id, name, email, department_id, created_by, created_date, last_modified_by, last_modified_date)
    VALUES (1, 'Alice Johnson', 'alice.johnson@example.com', 1, 'system', CURRENT_TIMESTAMP, 'system', CURRENT_TIMESTAMP);
INSERT INTO employee (id, name, email, department_id, created_by, created_date, last_modified_by, last_modified_date)
    VALUES (2, 'Bob Smith', 'bob.smith@example.com', 1, 'system', CURRENT_TIMESTAMP, 'system', CURRENT_TIMESTAMP);
INSERT INTO employee (id, name, email, department_id, created_by, created_date, last_modified_by, last_modified_date)
    VALUES (3, 'Carla Diaz', 'carla.diaz@example.com', 2, 'system', CURRENT_TIMESTAMP, 'system', CURRENT_TIMESTAMP);
INSERT INTO employee (id, name, email, department_id, created_by, created_date, last_modified_by, last_modified_date)
    VALUES (4, 'David Lee', 'david.lee@example.com', 2, 'system', CURRENT_TIMESTAMP, 'system', CURRENT_TIMESTAMP);
INSERT INTO employee (id, name, email, department_id, created_by, created_date, last_modified_by, last_modified_date)
    VALUES (5, 'Emma Brown', 'emma.brown@example.com', 3, 'system', CURRENT_TIMESTAMP, 'system', CURRENT_TIMESTAMP);
ALTER TABLE employee ALTER COLUMN id RESTART WITH 6;
