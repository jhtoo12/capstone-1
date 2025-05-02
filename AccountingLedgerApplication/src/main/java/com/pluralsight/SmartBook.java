package com.pluralsight;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class SmartBook {

    public static Scanner sc = new Scanner(System.in);
    public static File file = new File("Data/Dexter.csv");
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static double balance;


    public static boolean running;

    public static void main(String[] args) {
        balance = 1000;
        running = true;
        while (running) {
            HomeScreen();
//            String HomeScreen = sc.nextLine();
            System.out.println("----");
        }
    }

    public static void HomeScreen() {
        System.out.println("------------------------");
        System.out.println("Home Screen");
        System.out.println("------------------------");
        System.out.println("Where do you want to go?");
        System.out.println("------------------------");
        System.out.println(" D: Add Deposit");
        System.out.println(" P: Make a Payment");
        System.out.println(" L: See Ledgar Record");
        System.out.println(" X: Exit Page");
        System.out.println(" ");
        System.out.println("Enter a command");

        String option = sc.nextLine();

        switch (option.toUpperCase()) {
            case "D":
                addDeposit();
                break;
            case "P":
                makePayment();
                break;
            case "L":
                Ledgar();
                break;
            case "X":
                System.out.println("Goodbye");
                running = false;
                break;
            default:
                System.out.println("Error!!. Try again.");

        }
    }

    public static void addDeposit() {
        System.out.println("Add Deposit Amount: ");
        double depositAmount = sc.nextDouble();
        balance += depositAmount;
        sc.nextLine();

        LocalDateTime time = LocalDateTime.now();
        Transaction transaction = new Transaction(time, depositAmount);

        try {
            FileWriter fileWriter = new FileWriter("Data/Dexter.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n" + transaction.toCsv());

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }


    }

    public static void makePayment() {
        String paymentDescription;
        String paymentVendor;
        double paymentPrice;

        System.out.print("\n Add Description: ");
        paymentDescription = sc.nextLine();

        System.out.print("\n Add Vendor: ");
        paymentVendor = sc.nextLine();

        System.out.print("\n Add Price: ");
        paymentPrice = sc.nextDouble();
        paymentPrice *= -1;
        sc.nextLine();

        LocalDateTime time = LocalDateTime.now();
        Transaction transaction = new Transaction(time, paymentDescription, paymentVendor, paymentPrice);

        try {
            FileWriter fileWriter = new FileWriter("Data/Dexter.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("\n" + transaction.toCsv());

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }

        HomeScreen();
    }

    private static void Ledgar() {
        System.out.println("------------------------");
        System.out.println("Ledgar");
        System.out.println("------------------------");
        System.out.println("Where do you want to go?");
        System.out.println("------------------------");
        System.out.println(" A: Display all Entries");
        System.out.println(" D: Deposits");
        System.out.println(" P: Payments");
        System.out.println(" R: Reports");
        System.out.println(" H: Home");
        System.out.println(" ");
        System.out.println("Enter a command");

        String option = sc.nextLine();

        switch (option.toUpperCase()) {
            case "A":
                All();
                break;
            case "D":
                Deposits();
                break;
            case "P":
                Payments();
                break;
            case "R":
                Reports();
                break;
            case "H":
                HomeScreen();
                break;
            default:
                System.out.println("Error!!. Try again.");

        }
    }

    private static void All() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            while (line != null) {
                System.out.println(line);
                length += line.length();
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }

    private static void Deposits() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            double price = 0;

            while (line != null) {
                String tempLine = line;
                String[] tokens = tempLine.split("\\|");
                if (!tokens[4].equals("amount")) {
                    price = Double.parseDouble(tokens[4]);
                }

                if (price > 0) {
                    System.out.println(line);
                }

                length += line.length();
                line = bufferedReader.readLine();

            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }

    private static void Payments() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            double price = 0;

            while (line != null) {
                String tempLine = line;
                String[] tokens = tempLine.split("\\|");
                if (!tokens[4].equals("amount")) {
                    price = Double.parseDouble(tokens[4]);
                }

                if (price < 0) {
                    System.out.println(line);
                }

                length += line.length();
                line = bufferedReader.readLine();

            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }

    private static void Reports() {
        System.out.println("------------------------");
        System.out.println("Reports");
        System.out.println("------------------------");
        System.out.println("What are you searching for?");
        System.out.println("------------------------");
        System.out.println(" 1: Month to Date");
        System.out.println(" 2: Previous Month");
        System.out.println(" 3: Year To Date");
        System.out.println(" 4: Previous Year");
        System.out.println(" 5: Search by Vendor");
        System.out.println(" 0: Back");
        System.out.println(" ");
        System.out.println("Enter a command");

        String option = sc.nextLine();

        switch (option) {
            case "1":
                MonthToDate();
                break;
            case "2":
                PreviousMonth();
                break;
            case "3":
                YearToDate();
                break;
            case "4":
                PreviousYear();
                break;
            case "5":
                Vendor();
            case "0":
                Reports();
                break;
            default:
                System.out.println("Error!!. Try again.");

        }
    }

    private static void MonthToDate() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            String[] tokens = new String[5];
            String[] dateTokens = new String[3];

            LocalDateTime currentDay = LocalDateTime.now();
            int currentMonthValue = currentDay.getMonthValue();

            String currentMonth = String.valueOf(currentMonthValue);
            if(currentMonthValue != 10 && currentMonthValue != 11 && currentMonthValue != 12) {
                currentMonth = "0" + currentMonth;
            }

            while (line != null) {
                String tempLine = line;
                String tempDate = "";
                tokens = tempLine.split("\\|");
                if (!tokens[0].equals("date")) {
                    tempDate = tokens[0];
                    dateTokens = tempDate.split("-");

                    if(dateTokens[1].equals(currentMonth)) {
                        System.out.println(line);
                    }
                }

                length += line.length();
                line = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }


    private static void PreviousMonth() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            String[] tokens = new String[5];
            String[] dateTokens = new String[3];

            LocalDateTime currentDay = LocalDateTime.now();
            int lastMonthValue = currentDay.getMonthValue();
            if(lastMonthValue == 1) {
                lastMonthValue = 12;
            }
            else {
                lastMonthValue--;
            }

            String lastMonth = String.valueOf(lastMonthValue);
            if(lastMonthValue != 10 && lastMonthValue != 11 && lastMonthValue != 12) {
                lastMonth = "0" + lastMonth;
            }

            while (line != null) {
                String tempLine = line;
                String tempDate = "";
                tokens = tempLine.split("\\|");
                if (!tokens[0].equals("date")) {
                    tempDate = tokens[0];
                    dateTokens = tempDate.split("-");

                    if(dateTokens[1].equals(lastMonth)) {
                        System.out.println(line);
                    }
                }

                length += line.length();
                line = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }

    private static void YearToDate() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            String[] tokens = new String[5];
            String[] dateTokens = new String[3];

            LocalDateTime currentDay = LocalDateTime.now();
            int currentYearValue = currentDay.getYear();

            String currentYear = String.valueOf(currentYearValue);

            while (line != null) {
                String tempLine = line;
                String tempDate = "";
                tokens = tempLine.split("\\|");
                if (!tokens[0].equals("date")) {
                    tempDate = tokens[0];
                    dateTokens = tempDate.split("-");

                    if(dateTokens[0].equals(currentYear)) {
                        System.out.println(line);
                    }
                }

                length += line.length();
                line = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }

    private static void PreviousYear() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            String[] tokens = new String[5];
            String[] dateTokens = new String[3];

            LocalDateTime currentDay = LocalDateTime.now();
            int lastYearValue = currentDay.getYear();
            lastYearValue--;

            String lastYear = String.valueOf(lastYearValue);

            while (line != null) {
                String tempLine = line;
                String tempDate = "";
                tokens = tempLine.split("\\|");
                if (!tokens[0].equals("date")) {
                    tempDate = tokens[0];
                    dateTokens = tempDate.split("-");

                    if(dateTokens[0].equals(lastYear)) {
                        System.out.println(line);
                    }
                }

                length += line.length();
                line = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }

    private static void Vendor() {
        try {
            FileReader fileReader = new FileReader("Data/Dexter.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int length = 0;
            String[] tokens = new String[5];

            System.out.println("Enter vendor: ");
            String targetVendor = sc.nextLine();

            while (line != null) {
                String tempLine = line;
                String tempDate = "";
                tokens = tempLine.split("\\|");
                if (!tokens[3].equals("vendor")) {
                    if(tokens[3].equalsIgnoreCase(targetVendor)) {
                        System.out.println(line);
                    }
                }

                length += line.length();
                line = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Failed to write to file.");
        }
    }
}