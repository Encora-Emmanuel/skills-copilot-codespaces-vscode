package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 The Bakery inventory management system will allow users to add, delete, update, and search
for items in the inventory. Additionally, it will include a feature to alert users when stock
quantities of items reach zero, ensuring timely replenishment.
Acceptance Criteria:

- As a user, I want to be able to add new items to the inventory, providing details such
as item name, description, quantity, and price.
- When I enter valid item details and click the "Add" button, the item should be
successfully added to the inventory.
- If any required fields are missing or invalid, I should receive appropriate error
messages.
As a user, I want to be able to delete items from the inventory.
- When I select an item and click the "Delete" button, the item should be
removed from the inventory.
- A confirmation prompt should appear to prevent accidental deletion.
As a user, I want to be able to update existing items in the inventory.
- When I select an item and make changes to its details (e.g., quantity, price)
and click the "Update" button, the changes should be reflected in the
inventory.
- As a user, I want to be able to search for items in the inventory based on their
attributes (e.g., name, description).
- When I enter search criteria in the search bar and click the "Search" button,
the system should display a list of items matching the criteria.
o If no matching items are found, an appropriate message should be displayed.
- As a user, I want to receive alerts when the stock quantity of an item reaches zero.
-  When the stock quantity of an item reaches zero, the system should display an
alert message notifying users of the low stock level.
-  Users should have the option to ac
 */

/*
    Items Schema
Item ID Item Name Item Description Quantity Price 
Chocolate Cake Rich and decadent chocolate cake 10 $25.00
Vanilla Cake Classic vanilla sponge cake 8 $20.00
Carrot Cake Moist carrot cake with creamcheese frosting 6 $30.00
Tres Leches Cake Traditional Latin American sponge cake 4 $35.00
Chocolate Chip Cookie lassic chocolate chip cookie 15 $1.50
Snickerdoodle Cinnamon-sugar coated cookie 12 $1.75
Peanut Butter Cookie Rich and nutty peanut butter cookie 10 $2.00
Biscoff Cookies Crunchy and caramel-flavored Cookies 8 $1.50
Butter Pecan Cookies Buttery and nutty pecan cookie 6 $2.25


    Alerts Schema   
Alert ID (unique identifier)
Item ID (linked to Item object)
Alert Message
Alert Status (acknowledged or pending)
 */

public class Main {
    public static void main(String[] args) {
        // Create an instance of the inventory management system
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Add items to the inventory
        Item chocolateCake = new Item("Chocolate Cake", "Rich and decadent chocolate cake", 10, 25.00);
        ims.addItem(chocolateCake);

        Item vanillaCake = new Item("Vanilla Cake", "Classic vanilla sponge cake", 8, 20.00);
        ims.addItem(vanillaCake);

        Item carrotCake = new Item("Carrot Cake", "Moist carrot cake with creamcheese frosting", 6, 30.00);
        ims.addItem(carrotCake);

        Item tresLechesCake = new Item("Tres Leches Cake", "Traditional Latin American sponge cake", 4, 35.00);
        ims.addItem(tresLechesCake);

        Item chocolateChipCookie = new Item("Chocolate Chip Cookie", "Classic chocolate chip cookie", 15, 1.50);
        ims.addItem(chocolateChipCookie);

        Item snickerdoodle = new Item("Snickerdoodle", "Cinnamon-sugar coated cookie", 12, 1.75);
        ims.addItem(snickerdoodle);

        Item peanutButterCookie = new Item("Peanut Butter Cookie", "Rich and nutty peanut butter cookie", 10, 2.00);
        ims.addItem(peanutButterCookie);

        Item biscoffCookies = new Item("Biscoff Cookies", "Crunchy and caramel-flavored Cookies", 8, 1.50);
        ims.addItem(biscoffCookies);

        Item butterPecanCookies = new Item("Butter Pecan Cookies", "Buttery and nutty pecan cookie", 6, 2.25);
        ims.addItem(butterPecanCookies);

        // Delete an item from the inventory
        ims.deleteItem(chocolateCake);

        // Update an item in the inventory
        vanillaCake.setQuantity(10);
        vanillaCake.setPrice(22.50);
        ims.updateItem(vanillaCake);

        // Search for items in the inventory
        List<Item> searchResults = ims.searchItems("cookie");
        System.out.println("Search Results:");
        for (Item item : searchResults) {
            System.out.println(item);
        }

        // Check for low stock alerts
        List<Item> lowStockItems = ims.getLowStockItems();
        System.out.println("Low Stock Items:");
        for (Item item : lowStockItems) {
            System.out.println(item);
        }
    }
}

class Item {
    private String name;
    private String description;
    private int quantity;
    private double price;

    public Item(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters

    public void setPrice(double d) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManagementSystem {
    private List<Item> inventory;

    public InventoryManagementSystem() {
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        // Validate required fields
        if (item.getName() == null || item.getName().isEmpty() ||
                item.getDescription() == null || item.getDescription().isEmpty() ||
                item.getQuantity() <= 0 || item.getPrice() <= 0) {
            System.out.println("Error: Missing or invalid item details. Please provide all required fields.");
            return;
        }

        // Add the item to the inventory
        inventory.add(item);
    }

    public void deleteItem(Item item) {
        // Display a confirmation prompt
        System.out.println("Are you sure you want to delete this item? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("Y")) {
            inventory.remove(item);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public void updateItem(Item item) {
        // Find the item in the inventory and update its details
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(item.getName())) {
                inventory.set(i, item);
                break;
            }
        }
    }

    public List<Item> searchItems(String keyword) {
        List<Item> searchResults = new ArrayList<>();
        for (Item item : inventory) {
            if (((String) item.getName()).toLowerCase().contains(keyword.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public List<Item> getLowStockItems() {
        List<Item> lowStockItems = new ArrayList<>();
        for (Item item : inventory) {
            if (item.getQuantity() == 0) {
                lowStockItems.add(item);
            }
        }
        return lowStockItems;
    }
}