CREATE TABLE IF NOT EXISTS Customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(255),
    customer_email VARCHAR(255),
    customer_phone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS DeliveryAddresses (
    address_id INT PRIMARY KEY,
    customer_id INT,
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    postal_code VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);
