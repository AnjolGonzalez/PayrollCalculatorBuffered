package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;
    private double grossPay;

    public Employee(int id, String name, double hours, double payTime) {
        this.employeeId = id;
        this.name = name;
        this.hoursWorked = hours;
        this.payRate = payTime;
        this.grossPay = grossPay;
    }

    public int getEmployeeId (){
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public double getPayRate() {
        return payRate;
    }
    public void setPayRate(double payRate){
        this.payRate = payRate;
    }
    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }
    public double getgrossPay(){
        return hoursWorked * payRate;
        }
    }

