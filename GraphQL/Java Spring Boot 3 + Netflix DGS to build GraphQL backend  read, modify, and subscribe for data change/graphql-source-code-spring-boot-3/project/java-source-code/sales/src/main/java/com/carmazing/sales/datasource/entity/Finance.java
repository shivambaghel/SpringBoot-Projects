package com.carmazing.sales.datasource.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.UUID;

@Entity
@Table(name = "finances")
public class Finance {

    @Id
    @GeneratedValue
    private UUID uuid;

    private double baseAmount;

    private double taxAmount;

    private double discountAmount;

    private boolean isLoan;

    @OneToOne
    @JoinColumn(name = "sales_order_uuid")
    private SalesOrder salesOrder;

    @OneToOne(mappedBy = "finance")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Loan loan;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public void setLoan(boolean loan) {
        isLoan = loan;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
