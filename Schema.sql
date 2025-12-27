-- 1:Table customers

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    address VARCHAR(255)
);



-- 2:Table events

CREATE TABLE events (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    event_type VARCHAR(50) NOT NULL,   -- e.g., Marriage, Birthday, Engagement
    event_date DATE NOT NULL,
    event_time TIME,
    FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);



-- 3:Table payment

CREATE TABLE payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);