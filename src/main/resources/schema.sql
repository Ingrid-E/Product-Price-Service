CREATE TABLE IF NOT EXISTS Brand (
    brand_id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Price (
  price_list int AUTO_INCREMENT PRIMARY KEY,
  brand_id int NOT NULL,
  start_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  product_id int NOT NULL,
  priority int DEFAULT 0,
  price DECIMAL(18,2) NOT NULL,
  curr VARCHAR(20) NOT NULL,
  FOREIGN KEY(brand_id) REFERENCES Brand(brand_id)
);

CREATE INDEX idx_brand_product ON Price(product_id, brand_id);
