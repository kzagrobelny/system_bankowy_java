package com.company;

import java.sql.SQLException;

public interface AccountOperations {

    double checkBalance() throws SQLException;

    void moneyTransfer(double amount, int secondClientID) throws AccountOperationException, SQLException;

    void makeADeposit(double amount) throws SQLException;

}
