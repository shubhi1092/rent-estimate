CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    ip_address VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    phone_number VARCHAR(20),
    address VARCHAR(500),
    zipcode INT,
    estimated_rent_currency VARCHAR(10),
    estimated_rent_lower INT,
    estimated_rent_upper INT,
    expected_rent_currency VARCHAR(10),
    expected_rent_lower INT,
    expected_rent_upper INT
);
INSERT INTO users(
    ip_address,
    first_name,
    last_name,
    email_address,
    phone_number
) VALUES(
    '0.0.0.0',
    'test_first_name',
    'test_last_name',
    'test@test.com',
    '00000'
) RETURNING id;