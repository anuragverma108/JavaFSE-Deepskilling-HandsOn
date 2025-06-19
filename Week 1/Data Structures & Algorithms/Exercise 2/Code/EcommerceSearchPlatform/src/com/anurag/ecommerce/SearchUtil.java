package com.anurag.ecommerce;

public class SearchUtil {


    public static Product linearSearch(Product[] products, String targetName) {
        for (Product prod : products) {
            if (prod.getProductName().equalsIgnoreCase(targetName)) {
                return prod;
            }
        }
        return null;
    }


    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }


    public static void sortByName(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {
                if (products[j].getProductName().compareToIgnoreCase(products[j + 1].getProductName()) > 0) {
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }
}
