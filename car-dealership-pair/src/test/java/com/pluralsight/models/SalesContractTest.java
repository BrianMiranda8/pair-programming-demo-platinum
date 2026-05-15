package com.pluralsight.models;

import com.pluralsight.abstracts.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {


    @Test
    void check_monthly_payment_if_car_is_over_10k(){
        // arrange
        Vehicle vehicle =  new Vehicle(1234,2010,"","","","",300000,10001);

        SalesContract contract = new SalesContract("","","",vehicle);
        contract.setFinance(true);

        //act
        double expectedMonthlyPayment = 227;
            double monthlyPayment = contract.getMonthlyPayment();

        // assert
            assertEquals(expectedMonthlyPayment,monthlyPayment, "Monthly payment should be equal to expected monthly payment");
    }

    @Test
    void check_monthly_payment_if_car_is_under_100k(){
        // arrange
        Vehicle vehicle =  new Vehicle(1234,2010,"","","","",300000,9999);

        SalesContract contract = new SalesContract("","","",vehicle);
        contract.setFinance(true);

        //act
        double expectedMonthlyPayment = 440;
        double monthlyPayment = contract.getMonthlyPayment();

        // assert
        assertEquals(expectedMonthlyPayment,monthlyPayment, "Monthly payment should be equal to expected monthly payment");
    }

    @Test
    void check_total_posttax_amount(){
        // arrange
        Vehicle vehicle =  new Vehicle(1234,2010,"","","","",300000,10001);
        SalesContract contract = new SalesContract("","","",vehicle);

        // act

        double totalAmount = contract.getTotalPrice();
        double expectedTotal = 11125.80;
        // assert

        assertEquals(expectedTotal, totalAmount, " Total amount should be equal to expectedTotal");

    }




}