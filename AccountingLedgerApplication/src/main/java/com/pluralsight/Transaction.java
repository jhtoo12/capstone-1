package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {
    private LocalDateTime time;
    private String description;
    private String vendor;
    private double price;


    public Transaction(LocalDateTime localDateTime, double price) {
        this.time = localDateTime;
        this.description = "";
        this.vendor = "";
        this.price = price;
    }

    public Transaction(LocalDateTime localDateTime, String description, String vendor, double price) {
        this.time = localDateTime;
        this.description = description;
        this.vendor = vendor;
        this.price = price;

    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "time=" + time +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                '}';
    }

    public String toCsv() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");
        StringBuilder builder = new StringBuilder();
        builder.append(time.format(format)).append("|").append(description).append("|").append(vendor)
                .append("|").append(price);

        return builder.toString();

    }
}

//    public String toString() {
//        String depositDescription = String.format("%s|%s|%f, description, vendor, price");
//        return depositDescription;
//
//    }
//}
//    public String display



//    @Override
//    public String toString() {
//        String deposit = String.format("%2006-11-25|18:00:00|dinner with Rita|Ocean Grill|-65.00");

//        return "App{" +
//                "localDateTime=" + localDateTime +
//                ", description='" + description + '\'' +
//                ", vendor='" + vendor + '\'' +
//                ", price=" + price +
//                '}';

//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//}