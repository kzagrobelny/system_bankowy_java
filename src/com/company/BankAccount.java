package com.company;

import javax.annotation.processing.Generated;
import java.sql.SQLException;
import java.util.ArrayList;

public class BankAccount extends DB implements AccountOperations {
    private String firstName;
    private String lastName;
    private double balance = 0;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int clientsID;


    public BankAccount(String firstName, String lastName) throws SQLException {
        this.firstName = firstName;
        this.lastName = lastName;
        if(super.getID(firstName, lastName) == -1){
            super.createNewClient(firstName, lastName);
        }
        this.clientsID = super.getID(firstName, lastName);
    }

    @Override
    public double checkBalance() throws SQLException {
        return super.checkBalance(clientsID);
    }

    @Override
    public void moneyTransfer(double amount, int secondClientID) throws AccountOperationException, SQLException {
        super.moneyTransfer(amount, this.clientsID, secondClientID);
    }

    @Override
    public void makeADeposit(double amount) throws SQLException {
        super.makeADeposit(clientsID, amount);
    }
}
