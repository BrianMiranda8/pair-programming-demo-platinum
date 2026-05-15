package com.pluralsight.models;

import com.pluralsight.abstracts.Contract;

public class SalesContract extends Contract {

    private final double SALESTAX = 0.05;
    private final double RERCORDINGFEE = 100;

    private boolean finance;
    private double PROCESSINGFEE;

    public void setFinance(boolean finance){
        this.finance = finance;
    }

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicle) {
        super(dateOfContract, customerName, customerEmail, vehicle);
        if (vehicle.getPrice()>10000){
            this.PROCESSINGFEE = 495;
        }
        else {
            this.PROCESSINGFEE = 295;
        }
    }

    public boolean isFinance() {
        return finance;
    }

    @Override
    public Double getTotalPrice() {
        double totalAmount = getVehicle().getPrice() +  PROCESSINGFEE +  RERCORDINGFEE;
        double taxAmount = totalAmount * SALESTAX;
        return  taxAmount + totalAmount;

    }

    @Override
    public Double getMonthlyPayment() {
        Vehicle userVehicle = super.getVehicle();

        if (userVehicle==null){return null;}
        if (!finance){return null;}

        double vehiclePrice = userVehicle.getPrice();

        int paymentPlan = 48;
        double interestRate = .0425;

        if (vehiclePrice <= 10000){
            paymentPlan = 24;
            interestRate = .0525;
        }

        double monthlyInterestRate = interestRate / 12;

        double monthlyPayment = vehiclePrice * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, paymentPlan) / (Math.pow(1 + monthlyInterestRate, paymentPlan) - 1));

        return (double) Math.round(monthlyPayment);
    }
}
