package com.bkenterprises.invoices.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendor {

    private @Id String uuid;
    private String name;
    private String address;
    private String city;

}
