package com.company;

public class Transaction {
    private BankAccount transferOutgoingAcc, incomingTransferAccNumber;
    private double amount;

    public Transaction(double amount, BankAccount transferOutgoingAccNumber, BankAccount incomingTransferAccNumber) {
        this.amount = amount;
        this.transferOutgoingAcc = transferOutgoingAccNumber;
        this.incomingTransferAccNumber = incomingTransferAccNumber;
    }

    public double getAmount() {
        return amount;
    }

    public BankAccount getTransferOutgoingAcc() {
        return transferOutgoingAcc;
    }

    public BankAccount getIncomingTransferAcc() {
        return incomingTransferAccNumber;
    }
}
