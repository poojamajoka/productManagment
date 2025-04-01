package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Product {
    private long productId;
    private String name;
    private String dateSupplied;
    private int quantityInStock;
    private double unitPrice;
    // Default constructor
    public Product() {
    }

    // Constructor with parameters
    public Product(long productId, String name, LocalDate dateSupplied,
                   int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied.format(FORMATTER); ;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(long productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied.format(FORMATTER);
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDateSupplied() {
        return dateSupplied; // Convert String back to LocalDate
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

}
