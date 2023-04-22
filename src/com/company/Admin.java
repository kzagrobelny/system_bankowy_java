package com.company;

import java.util.ArrayList;
import java.util.UUID;

public class Admin extends Employee{
    private String adminID;

    {
        adminID = UUID.randomUUID().toString();
    }

    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        System.out.println("Pracownik dodany!");
    }

    public void deleteEmployee(Employee employee){
        employee.setFirstName(null);
        employee.setLastName(null);
        employee.setEmployeeID(null);
        System.gc();
        System.out.println("Pracownik usunięty!");
    }
}
