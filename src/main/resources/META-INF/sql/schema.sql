DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
  id INT NOT NULL AUTO_INCREMENT,
  reg_date DATE,
  customer VARCHAR(20),
  product VARCHAR(20),
  amount INT,
  PRIMARY KEY (id)
);