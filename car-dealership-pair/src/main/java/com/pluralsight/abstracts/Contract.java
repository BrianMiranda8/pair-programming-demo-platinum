package com.pluralsight.abstracts;

import com.pluralsight.models.Vehicle;

abstract public class Contract {
    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
    private Double totalPrice;
    private Double monthlyPayment;


    public abstract Double getTotalPrice();

    public abstract Double getMonthlyPayment();
}
