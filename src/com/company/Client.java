package com.company;


import java.sql.SQLException;


public class Client extends User implements AccountOperations{
    private BankAccount bankAccount;
    private int clientID;

    {
        bankAccount = new BankAccount(getFirstName(), getLastName());
        clientID = bankAccount.getID(this);
    }

    public int getClientID() {
        return clientID;
    }

    public Client(String firstName, String lastName) throws SQLException {
        super(firstName, lastName);
    }

    @Override
    public double checkBalance() throws SQLException {
        return bankAccount.checkBalance(clientID);
    }

    @Override
    public void moneyTransfer(double amount, int secondClientID) throws AccountOperationException, SQLException {
        bankAccount.moneyTransfer(amount, secondClientID);
    }

    @Override
    public void makeADeposit(double amount) throws SQLException {
        bankAccount.makeADeposit(amount);
    }

    public void withdraw(int amount) throws SQLException {
        bankAccount.withdraw(amount, clientID);
    }
}
