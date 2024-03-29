CREATE TABLE application (
    application_id INT PRIMARY KEY,
    app_name VARCHAR(255),
    description VARCHAR(255),
    owner VARCHAR(255)
);
INSERT INTO application (application_id, app_name, description, owner) VALUES (1, 'Trackzilla','A bug tracking application', 'Kesha Williams');
INSERT INTO application (application_id, app_name, description, owner) VALUES (2, 'Expenses','An application used to submit expenses', 'Jane Doe');
INSERT INTO application (application_id, app_name, description, owner) VALUES (3, 'Bookings','An application used to book tickets', 'John Doe');
INSERT INTO application (application_id, app_name, description, owner) VALUES (4, 'Invoice Search','An application used to search invoices ', 'Mary Richards');
INSERT INTO application (application_id, app_name, description, owner) VALUES (5, 'Audits','An application used for auditing purposes.', 'Tiffany Stewart');

CREATE TABLE IF NOT EXISTS ticket (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255),
    application_id INT,
    status VARCHAR(50),
    FOREIGN KEY (application_id) REFERENCES application(application_id)
);
INSERT INTO ticket (id, title, description, application_id, status) VALUES (1, 'Sort Feature','Add the ability to sort tickets by severity',1,'OPEN');
INSERT INTO ticket (id, title, description, application_id, status) VALUES (2, 'Search Feature','Add the ability to search by invoice date',4,'IN PROGRESS');
INSERT INTO ticket (id, title, description, application_id, status) VALUES (3, 'Audit','Add the ability to audit by year',5,'CLOSED');
INSERT INTO ticket (id, title, description, application_id, status) VALUES (4, 'Booking Feature','Add the ability to book tickets online',3,'OPEN');

CREATE TABLE IF NOT EXISTS release (
    id INT PRIMARY KEY,
    description VARCHAR(255),
    release_date DATE
);
INSERT INTO release (id, description, release_date) VALUES (1,'Q1 Release Containing High Priority Bugs', '2030-02-14');
INSERT INTO release (id, description, release_date) VALUES (2,'Q2 Release Containing High Priority Enhancements', '2030-05-27');
INSERT INTO release (id, description, release_date) VALUES (3,'Q3 Release Containing Bugs', '2030-09-14');
INSERT INTO release (id, description, release_date) VALUES (4,'Q4 Release Containing Enhancements', '2030-12-10');

-- Create ticket_release table
CREATE TABLE IF NOT EXISTS ticket_release (
    release_fk INT,
    ticket_fk INT,
    FOREIGN KEY (release_fk) REFERENCES release(id),
    FOREIGN KEY (ticket_fk) REFERENCES ticket(id)
);
INSERT INTO ticket_release (release_fk, ticket_fk) VALUES (1,3);
INSERT INTO ticket_release (release_fk, ticket_fk) VALUES (2,1);
INSERT INTO ticket_release (release_fk, ticket_fk) VALUES (2,4);
