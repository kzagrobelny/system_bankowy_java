package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        Client client = new Client("Jakub", "Zagrobelny");
        Client client2 = new Client("Natalia", "Matysiak");
        Client client3 = new Client("Jan", "Kowalski");


        System.out.println(client.checkBalance());

    }
}
