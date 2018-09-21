CREATE TABLE Txn
(
    id long PRIMARY KEY,
    order_id long,
    txn_desc varchar2,
    CONSTRAINT Txn_Customer_id_fk FOREIGN KEY (order_id) REFERENCES Customer (id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Customer
(
    id long PRIMARY KEY,
    txn_id long NOT NULL,
    cust_name varchar2,
    CONSTRAINT Customer_Txn_id_fk FOREIGN KEY (txn_id) REFERENCES Txn (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE CustomerOrder
(
    id long PRIMARY KEY,
    txn_id long NOT NULL,
    cust_name varchar2,
    CONSTRAINT Customer_Txn_id_fk FOREIGN KEY (txn_id) REFERENCES Txn (id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO tbl_book (id, name, price) VALUES (1, 'Spring Boot - Spring Data JPA with Hibernate and H2 Web Console', 0.0)