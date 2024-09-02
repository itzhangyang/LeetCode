package com.leetcode.learning.design.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductInventoryManager {
    private final Map<String, Product> products;
    private final Map<String, Integer> inventory;

    public ProductInventoryManager() {
        products = new HashMap<>();
        inventory = new HashMap<>();
    }

    // Method to add a product to the inventory
    public void addProduct(Product product, int quantity) {
        products.put(product.getProductId(), product);
        inventory.put(product.getProductId(), quantity);
    }

    // Method to update the quantity of a product in the inventory
    public void updateQuantity(String productId, int newQuantity) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, newQuantity);
        }
    }

    // Method to remove a product from the inventory
    public void removeProduct(String productId) {
        products.remove(productId);
        inventory.remove(productId);
    }

    // Method to get the current quantity of a product in the inventory
    public int getQuantity(String productId) {
        return inventory.getOrDefault(productId, 0);
    }

    // Method to get all products in the inventory
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
}