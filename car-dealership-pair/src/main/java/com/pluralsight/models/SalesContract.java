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
        return 0.0;





    }

    @Override
    public Double getMonthlyPayment() {
        return 0.0;
    }
}
