package com.carmazing.sales.datasource.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue
    private UUID uuid;

    private String financeCompany;

    private String contactPersonName;

    private String contactPersonPhone;

    private String contactPersonEmail;

    @OneToOne
    @JoinColumn(name = "finance_uuid")
    private Finance finance;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFinanceCompany() {
        return financeCompany;
    }

    public void setFinanceCompany(String financeCompany) {
        this.financeCompany = financeCompany;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonPhone() {
        return contactPersonPhone;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }
}
