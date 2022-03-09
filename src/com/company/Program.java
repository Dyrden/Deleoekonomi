package com.company;

import java.util.Scanner;

public class Program {
    private boolean running = true;
    private Scanner sc = new Scanner(System.in);
    private Catalogue catalogue = new Catalogue(10);

    public static void main(String[] args) {
        new Program().run();
    }

    public void run() {
        Item item1 = new Item("Sport", "Basketball");
        Item item2 = new Item("Sport", "Skateboard");
        Item item3 = new Item("Sport", "Football");
        Item item4 = new Item("Sport", "Rollerskates");
        Item item5 = new Item("Sport", "Volleyball");
        Item item6 = new Item("Outdoors", "Tent");
        Item item7 = new Item("Sport", "Skateboard");
        catalogue.addItem(item1);
        catalogue.addItem(item2);
        catalogue.addItem(item3);
        catalogue.addItem(item4);
        catalogue.addItem(item5);
        catalogue.addItem(item6);
        catalogue.addItem(item7);

        System.out.println("Hvad kunne du tænke dig?");
        while (running) {
            displayChoice();
            choice(sc.nextLine());
        }
    }

    private void displayChoice() {
        System.out.println("1. Look at the entire catalogue");
        System.out.println("2. See whats available");
        System.out.println("3. Add items to catalogue");
        System.out.println("4. Borrow item by description");
        System.out.println("5. Return item by description");
    }

    public void choice(String input) {
        switch (input.charAt(0)) {
            case '1' -> displayFullList();
            case '2' -> displayAvailableList();
            case '3' -> displayAddItem();
            case '4' -> displayLoanItem();
            case '5' -> displayReturnItem();
            case 'e' -> running = !running;
            default -> {
                System.out.println("Wrong input - input again");
                displayChoice();
                choice(sc.nextLine());
            }
        }
    }

    public void displayFullList() {
        Item[] allItems = catalogue.getFullList();
        for (Item item : allItems) {
            System.out.println(item);
        }
    }

    public void displayAvailableList() {
        Item[] allItems = catalogue.getAvailableItems();
        for (Item item : allItems) {
            System.out.println(item);
        }
    }


    public void displayAddItem() {
        System.out.println("Enter the directory of the item");
        String directory = sc.nextLine();
        System.out.println("Enter the description of the item");
        String description = sc.nextLine();
        Item item = new Item(directory, description);
        catalogue.addItem(item);
    }

    public void displayLoanItem() {
        System.out.println("Enter the description of the item you wish to borrow");
        String description = sc.nextLine();
        Item item = new Item(null, description);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        if (name.isBlank()) catalogue.loanItem(item);
        else catalogue.loanItem(item, name);

    }

    public void displayReturnItem() {
        System.out.println("Enter the description of the item you wish to return");
        String description = sc.nextLine();
        Item item = new Item(null, description);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        if (name.isBlank()) catalogue.returnItem(item, name);
        else catalogue.returnItem(item);
    }
}
