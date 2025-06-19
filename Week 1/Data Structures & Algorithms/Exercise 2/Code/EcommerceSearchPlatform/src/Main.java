package com.anurag.ecommerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] inventory = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Footwear"),
                new Product(103, "Chair", "Furniture"),
                new Product(104, "Book", "Stationery"),
                new Product(105, "Phone", "Electronics")
        };

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product name to search:");
        String searchName = sc.nextLine();


        Product result1 = SearchUtil.linearSearch(inventory, searchName);
        System.out.println("\n🔍 Linear Search Result:");
        System.out.println(result1 != null ? result1 : "No product found.");


        SearchUtil.sortByName(inventory);
        Product result2 = SearchUtil.binarySearch(inventory, searchName);
        System.out.println("\n🔍 Binary Search Result:");
        System.out.println(result2 != null ? result2 : "No product found.");
    }
}
