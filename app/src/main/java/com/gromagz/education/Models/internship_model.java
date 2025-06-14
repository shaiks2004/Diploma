package com.gromagz.education.Models;

public class internship_model {
    private String title;
    private String company;
    private String lastDate;
    private String eligibility;
    private String amount;

    public internship_model(String title, String company, String lastDate, String eligibility, String amount) {
        this.title = title;
        this.company = company;
        this.lastDate = lastDate;
        this.eligibility = eligibility;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getEligibility() {
        return eligibility;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getAmount() {
        return amount;
    }
}
