/**
 * @author EgoBlack, Pawianberater
 * 
 */

package src.Player.Inventory;

// Inventory.java
public class Inventory extends Item{
    private Item[] slots;
    private int size;

    public Inventory(int size) {
        this.size = size;
        this.slots = new Item[size];
    }

    public boolean addItem(Item item) {
        for (int i = 0; i < size; i++) {
            if (slots[i] == null) {
                slots[i] = item;
                return true;
            }
        }
        System.out.println("Dein Inventar ist voll Item wurde nicht Hinzugefügt!");
        return false; // Inventory is full
    }

    public boolean removeItem(int slot) {
        if (slot >= 0 && slot < size && slots[slot] != null) {
            slots[slot] = null;
            return true;
        }
        return false; // Invalid slot or slot is already empty
    }

    public Item getItem (int slot) {

        return new Item();
    }

    public void displayInventory() {
        for (int i = 0; i < size; i++) {
            if (slots[i] != null) {
                System.out.println("Slot " + (i + 1) + ": " + slots[i].name);
            } else {
                System.out.println("Slot " + (i + 1) + ": empty");
            }
        }
    }
}
