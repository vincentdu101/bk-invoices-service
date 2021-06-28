package com.bkenterprises.invoices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="invoices")
public class Invoice {

    @Column(name="uuid")
    private @Id String uuid;

    @Column(name="product_uuid")
    private String productUUID;

    @Column(name="vendor_uuid")
    private String vendorUUID;

    @Column(name="quantity")
    private int quantity;

    @Column(name="rate")
    private float rate;

    @Column(name="total_cost")
    private float totalCost;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="modified_on")
    private LocalDateTime modifiedOn;

    public Invoice() {}

    public Invoice(String uuid, String productUUID, String vendorUUID,
                   int quantity, float rate, float totalCost, LocalDateTime createdOn) {
        this.uuid = uuid;
        this.productUUID = productUUID;
        this.vendorUUID = vendorUUID;
        this.quantity = quantity;
        this.rate = rate;
        this.totalCost = totalCost;
        this.createdOn = createdOn;
    }

    public float getRate() {
        return rate;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getProductUUID() {
        return productUUID;
    }

    public String getUUID() {
        return uuid;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public String getVendorUUID() {
        return vendorUUID;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setProductUUID(String productUUID) {
        this.productUUID = productUUID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public void setVendorUUID(String vendorUUID) {
        this.vendorUUID = vendorUUID;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Invoice)) {
            return false;
        }

        Invoice invoice = (Invoice) o;
        return  this.uuid.equals(invoice.uuid) &&
                this.vendorUUID.equals(invoice.vendorUUID) &&
                this.productUUID.equals(invoice.productUUID) &&
                this.rate == invoice.rate &&
                this.quantity == invoice.quantity &&
                this.totalCost == invoice.totalCost &&
                this.createdOn.equals(invoice.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uuid, this.vendorUUID, this.productUUID, this.createdOn);
    }

}
