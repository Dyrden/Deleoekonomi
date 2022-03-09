package com.company;

public class Item {

    private String category;
    private String description;
    private boolean available;


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
        return "Category : " + category + ", Description : " + description + ", Available : " + available;
    }
}
