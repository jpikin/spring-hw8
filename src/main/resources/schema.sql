create table product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    price DOUBLE NOT NULL,
    main_store INT NOT NULL,
    reserve_store INT NOT NULL
);

create table persons (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    account DOUBLE NOT NULL
);