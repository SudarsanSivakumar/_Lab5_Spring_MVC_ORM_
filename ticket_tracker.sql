CREATE DATABASE ticket_tracker;
USE ticket_tracker;
CREATE TABLE ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL
);

SELECT * FROM ticket_tracker.ticket;
