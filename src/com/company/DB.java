package com.company;

import java.sql.*;

public abstract class DB {
    private Connection con = null;
    private  Statement st = null;
    private ResultSet rs = null;

    public double checkBalance(int clientID) throws SQLException {

        double balance = 0;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Kubson67");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select saldo from klienci where id_klienta = "+ clientID);

            if(rs.next()){
                balance =  rs.getDouble("saldo");
            }

        } catch (SQLException e) {
            System.out.println("nie.");
        } finally {
            con.close();
        }
        return balance;

    }

    public int getID(User u) throws SQLException {
        String firstName = u.getFirstName();
        String lastName = u.getLastName();
        Integer id = 0;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "******");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from klienci");

            while(rs.next()){
                if(rs.getString("lastname").equals(lastName) && rs.getString("firstname").equals(firstName)){
                    id = rs.getInt("id_klienta");
                }
            }

        } catch (SQLException e) {
            System.out.println("nie.");
        }finally {
            con.close();
        }

        if(id>0){
            return id;
        } else {
            return -1;
        }
    }

    public int getID(String firstName, String lastName) throws SQLException {
        Integer id = 0;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "******");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from klienci");

            while(rs.next()){
                if(rs.getString("lastname").equals(lastName) && rs.getString("firstname").equals(firstName)){
                    id = rs.getInt("id_klienta");
                }
            }

        } catch (SQLException e) {
            System.out.println("nie.");
        }finally {
            con.close();
        }

        if(id>0){
            return id;
        } else {
            return -1;
        }
    }

    public void makeADeposit(int clientsID, double amount) throws SQLException {

        double totalAmount = checkBalance(clientsID) + amount;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "*****");

            Statement st = con.createStatement();

            st.executeUpdate("update klienci set saldo = " + totalAmount + " where id_klienta = "+ clientsID);


        } catch (SQLException e) {
            System.out.println("nie.");
        }finally {
            con.close();
        }

    }

    public void moneyTransfer(double amount, int clientID, int secondClientID) throws SQLException {

        withdraw(amount, clientID);

        makeADeposit(secondClientID, amount);
    }

    public double withdraw(double amount, int clientID) throws SQLException {
        amount *= -1;

        makeADeposit(clientID, amount);

        return checkBalance(clientID);
    }

    public void createNewClient(String firstName, String lastName) throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "*****");

            Statement st = con.createStatement();

            st.executeUpdate(" insert into klienci (FirstName, LastName)"
                    + " values (" + firstName + ", "+ lastName+")");


        } catch (SQLException e) {
            System.out.println("nie.");
        }finally {
            con.close();
        }
    }
}
