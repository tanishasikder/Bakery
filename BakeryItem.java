/**
 * Abstract class representing a generic bakery item.
 * This class serves as a base for specific bakery items (e.g., cake, cookie, pie) 
 * that have a type and a quantity.
 */
public abstract class BakeryItem {
    protected BakeryEnum typeOfItem;
    protected int quantity;

    /**
     * Constructs a new {@code BakeryItem} with the specified type and quantity.
     *
     * @param typeOfItem the type of the bakery item as defined in {@code BakeryEnum}
     * @param quantity   the quantity of the bakery item being purchased
     */
    public BakeryItem(BakeryEnum typeOfItem, int quantity) {
        this.typeOfItem = typeOfItem;
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the bakery item, including its type 
     * and quantity.
     *
     * @return a string containing the bakery item's type and quantity
     */
    @Override
    public String toString() {
        return typeOfItem + ". Quantity: " + quantity;
    }
}
