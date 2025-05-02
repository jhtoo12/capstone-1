# capstone-1
Accounting Ledger Application

A Java-based Command-Line Interface (CLI) application designed to help users track financial transactions for personal or business use. This program allows users to record deposits and payments, view categorized transaction history, and generate summary reports—all stored in a CSV file.

This is a basic Accounting Ledger App that add deposit and take out payment and save those transaction to a csv file.

• Show all ledger entries • Filter transactions by deposits, payments, date ranges, or vendor • Store and retrieve data from a CSV file

Screenshot 2025-05-02 093636.png Screenshot 2025-05-02 093711.png Screenshot 2025-05-02 093748.png Interesting Code Example

One interesting part of the project is how it filters transactions by vendor;

Screenshot 2025-05-02 093837.png

if (!tokens[3].equals("vendor")) { if(tokens[3].equalsIgnoreCase(targetVendor)) { System.out.println(line);
