# capstone-1
Accounting Ledger Application

A Java-based Command-Line Interface (CLI) application designed to help users track financial transactions for personal or business use. This program allows users to record deposits and payments, view categorized transaction history, and generate summary reports—all stored in a CSV file.

This is a basic Accounting Ledger App that add deposit and take out payment and save those transaction to a csv file.

• Show all ledger entries • Filter transactions by deposits, payments, date ranges, or vendor • Store and retrieve data from a CSV file

https://github.com/jhtoo12/capstone-1/blob/main/Screenshot%202025-05-02%20093636.png

https://github.com/jhtoo12/capstone-1/blob/main/Screenshot%202025-05-02%20093711.png

https://github.com/jhtoo12/capstone-1/blob/main/Screenshot%202025-05-02%20093748.png

One interesting part of the project is how it filters transactions by vendor;

https://github.com/jhtoo12/capstone-1/blob/main/Screenshot%202025-05-02%20093837.png

public static void searchByVendor() { System.out.print("Enter vendor name to search: "); String searchVendor = scanner.nextLine().toLowerCase();


