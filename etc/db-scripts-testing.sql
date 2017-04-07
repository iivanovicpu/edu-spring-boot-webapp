DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  created_date DATE NOT NULL,
  PRIMARY KEY (id));

INSERT INTO customer(name,email,created_date)VALUES('mkyong','111@yahoo.com', '2017-02-11');
INSERT INTO customer(name,email,created_date)VALUES('yflow','222@yahoo.com', '2017-02-12');
INSERT INTO customer(name,email,created_date)VALUES('zilap','333@yahoo.com', '2017-02-13');

select * from customer