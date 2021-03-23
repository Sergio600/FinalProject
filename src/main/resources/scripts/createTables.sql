 CREATE TABLE USER (ID INT auto_increment,
                    LOGIN varchar(25) not null,
                    PASSWORD varchar(255) not null,
                    primary key(id));

 CREATE TABLE ORDERS (ID INT auto_increment,
                    USER_ID int not null,
                    TOTAL_PRICE double,
                    primary key(id));

 CREATE TABLE GOOD (ID INT auto_increment,
                    TITLE varchar(25) not null,
                    PRICE int not null,
                    primary key(id));

 CREATE TABLE ORDER_GOOD (ID INT auto_increment,
                    ORDER_ID int not null,
                    GOOD_ID int not null,
                    primary key(id));