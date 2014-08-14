CREATE TABLE dashboard(
idx INTEGER AUTO_INCREMENT PRIMARY KEY,
group_id VARCHAR(50),
product_id VARCHAR(50),
product_name VARCHAR(50),
product_count INTEGER,
product_price INTEGER,
product_total_price INTEGER,
sales_date TIMESTAMP
);