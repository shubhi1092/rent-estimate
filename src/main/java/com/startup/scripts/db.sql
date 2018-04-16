CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    phone_number VARCHAR(20),
    address VARCHAR(500),
    estimated_rent INTEGER,
    expected_rent INTEGER
);
INSERT INTO users(
    first_name,
    last_name,
    email_address,
    phone_number
) VALUES(
    'test_first_name',
    'test_last_name',
    'test@test.com',
    '00000'
) RETURNING id;