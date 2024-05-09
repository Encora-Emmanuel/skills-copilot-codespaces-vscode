import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class MainTest {
    private InventoryManagementSystem ims;

    @BeforeEach
    public void setUp() {
        ims = new InventoryManagementSystem();
    }

    @Test
    public void testAddItem() {
        Item item = new Item("Test Item", "Test Description", 5, 10.00);
        ims.addItem(item);
        List<Item> inventory = ims.getInventory();
        Assertions.assertTrue(inventory.contains(item));
    }

    @Test
    public void testDeleteItem() {
        Item item = new Item("Test Item", "Test Description", 5, 10.00);
        ims.addItem(item);

        // Mock user input for confirmation prompt
        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ims.deleteItem(item);
        List<Item> inventory = ims.getInventory();
        Assertions.assertFalse(inventory.contains(item));
    }
}