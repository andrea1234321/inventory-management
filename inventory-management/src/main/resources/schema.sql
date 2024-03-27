drop table if exists WAREHOUSE;
drop table if exists APPAREL;

create table WAREHOUSE (
	id INT AUTO_INCREMENT PRIMARY KEY,
	city VARCHAR(50),
	state VARCHAR(2),
	capacity INT
);

create table APPAREL (
	sku VARCHAR(50) PRIMARY KEY,
	category VARCHAR(10),
	size VARCHAR(1),
	location VARCHAR(3),
	FOREIGN KEY (warehouse_id) REFERENCES WAREHOUSE(id)
);
