package com.company;

public class Item {

    private String category;
    private String description;
    private boolean available;
    private String lender;


    public Item(String category, String description) {
        this.category = category;
        this.description = description;
        this.available = true;
    }

    public Item(String category, String description, boolean available) {
        this.category = category;
        this.description = description;
        this.available = available;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        if (!available) {
            return "Category: " + category + ", Description: " + description + ", Available: " + available + ", Borrower: " + lender;
        } else {
            return "Category: " + category + ", Description: " + description + ", Available: " + available;
        }
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }
}
