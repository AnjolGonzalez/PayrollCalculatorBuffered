package com.pluralsight;
import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fileChose;
        String fileMade;
        System.out.print("Enter the name of file of employee that you want to process: ");
        fileChose = scan.nextLine();
        System.out.println("Enter the name of the file you want to create");
        fileMade = scan.nextLine();

        while(fileMade.equals("employees.csv")){
            System.out.println("ERROR! ERROR!\n" +
                    "Try again:\n" +
                    "ENTER HERE: ");

            if (fileMade.equals("employees.csv")) {
                System.out.println("Cannot overwrite existing file 'employees.csv', please try again.");
            }
            fileMade = scan.nextLine();
        }

        try{
            FileReader fileReader = new FileReader("src/main/resources/" + fileChose );
            BufferedReader buffRead = new BufferedReader(fileReader);
            String input;

            FileWriter fileWriter = new FileWriter(fileMade);

            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            int printOnce = 0;
            while((input = buffRead.readLine()) != null){

                String[] employee = input.split("\\|");

                int id = Integer.parseInt(employee[0]);
                String name = employee[1];
                double hoursWorked = Double.parseDouble(employee[2]);
                double payRate = Double.parseDouble(employee[3]);
                Employee employees = new Employee(id ,name, (int) hoursWorked,payRate);
                double grossPay = employees.getgrossPay();
                String formattedGrossPay = String.format("%.2f", grossPay);
                System.out.printf("Employee ID: %d | Name: %s | Gross Pay: $%.2f%n", id , name, employees.getgrossPay());
                if (printOnce < 1){
                    bufWriter.write("id|name|hours-worked|pay-rate \n");
                    printOnce++;
                }
                bufWriter.write(id + "|" + name + "|" + "$" + formattedGrossPay);
                bufWriter.newLine();
            }
            buffRead.close();
            bufWriter.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
