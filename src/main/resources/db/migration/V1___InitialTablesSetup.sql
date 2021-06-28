CREATE TABLE vendors (
    uuid VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(1000) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NULL,
    zip_code VARCHAR(255) NULL,
    country VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (uuid)
);

CREATE TABLE invoices (
    uuid VARCHAR(255) NOT NULL,
    product_uuid VARCHAR(255) NOT NULL,
    vendor_uuid VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    rate DECIMAL(10, 2) NOT NULL,
    total_cost DECIMAL(10, 2) NOT NULL,
    created_on TIMESTAMP NOT NULL,
    PRIMARY KEY (uuid),
    FOREIGN KEY (vendor_uuid) REFERENCES vendors(uuid)
);

