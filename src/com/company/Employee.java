package com.company;

import java.sql.SQLException;
import java.util.UUID;

public class Employee extends User{
    private String employeeID;

    {
        employeeID = UUID.randomUUID().toString();
    }

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Client addClient(String firstName, String lastName) throws SQLException {
        return new Client(firstName, lastName);
    }

    public BankAccount openBankAccount(String clientsFirstName, String clientsLastName, int clientID) throws SQLException {
        return new BankAccount(clientsFirstName, clientsLastName);
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void makeADepositOnClientsAccount(Client client, double amount) throws SQLException {
        client.makeADeposit(amount);
    }

    /*public void makeATransaction(Client client, BankAccount incomingAcc, double amount) throws AccountOperationException, SQLException {
        client.moneyTransfer(incomingAcc, amount);
    }*/

    public void makeADepositOnOtherPersonAcc(BankAccount otherPersonAcc, double amount) throws SQLException {
        otherPersonAcc.makeADeposit(amount);
    }

}
