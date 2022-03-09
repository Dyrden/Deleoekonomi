package com.company;

public class Catalogue {

    private Item[] catalogue;


    public Catalogue(int size) {
        this.catalogue = new Item[size];
    }


    public void addItem(Item item) {
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] == null) {
                catalogue[i] = item;
                return;
            }
            if (i == catalogue.length - 1) {
                Item[] newCatalogue = new Item[this.catalogue.length + 1];
                for (int j = 0; j < catalogue.length; j++) {
                    newCatalogue[j] = catalogue[j];
                }
                newCatalogue[newCatalogue.length - 1] = item;
                catalogue = newCatalogue;
                return;
            }
        }
    }

    public Item[] getFullList() {
        return catalogue;
    }

    public Item[] getAvailableItems() {
        int size = 0;
        for (Item item : catalogue) {
            if (item != null && item.isAvailable()) {
                size++;
            }
        }
        Item[] availableItems = new Item[size];
        int counter = 0;
        for (Item item : catalogue) {
            if (item != null) {
                if (item.isAvailable()) {
                    availableItems[counter] = item;
                    counter++;
                }
            }
        }
        return availableItems;
    }

    public Item findItem(String description) {
        for (Item item : catalogue) {
            if (item.getDescription().equalsIgnoreCase(description)) {
                return item;
            }
        }
        return null;
    }

    public void loanItem(Item find, String name) {

        for (Item item : catalogue) {
            if (item.getDescription().equalsIgnoreCase(find.getDescription())) {
                item.setAvailable(false);
                item.setLender(name);
                break;
            }
        }
    }

    public void loanItem(Item find) {

        for (Item item : catalogue) {
            if (item.getDescription().equalsIgnoreCase(find.getDescription())) {
                item.setAvailable(false);
                break;
            }
        }
    }

    public void returnItem(Item found, String name) {
        for (Item item : catalogue) {
            if (item.getDescription().equalsIgnoreCase(found.getDescription()) && item.getLender().equalsIgnoreCase(name)) {
                item.setAvailable(true);
                item.setLender("");
                break;

            }
        }
    }
    public void returnItem(Item found) {
        for (Item item : catalogue) {
            if (item.getDescription().equalsIgnoreCase(found.getDescription())) {
                item.setAvailable(true);
                break;

            }
        }
    }
}
