package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {

    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 03, 31), 89, 2.99)
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getUnitPrice).reversed());

        // Print JSON format
        ObjectMapper jsonMapper = new ObjectMapper();
        try {
            String jsonOutput = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
            System.out.println("JSON Output:\n" + jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print XML format
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xmlOutput = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
            System.out.println("\nXML Output:\n" + xmlOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print CSV format
        System.out.println("\nCSV Output:");
        System.out.println("Product Id, Name, Date Supplied, Quantity In Stock, Unit Price");
        for (Product p : products) {
            System.out.println(p.getProductId() + ", " + p.getName() + ", " + p.getDateSupplied() + ", " + p.getQuantityInStock() + ", " + p.getUnitPrice());
        }
    }
}
