package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input;

            while ((input = bufferedReader.readLine()) != null){

            String[] employee = input.split("\\|");
            int id = Integer.parseInt(employee[0]);
            String name = employee[1];
            double hoursWorked = Double.parseDouble(employee[2]);
            double payRate = Double.parseDouble(employee[3]);

            Employee employees = new Employee(id, name, hoursWorked, payRate);

            System.out.printf("Employee ID: %s,Name: %s, GrossPay: $%.2f%n", employees.getEmployeeId(), employees.getName(), employees.getgrossPay());
        }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error!\n" +
                    "Try again:");
            e.printStackTrace();
        }


    }
}
