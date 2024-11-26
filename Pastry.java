/**
 * Represents a specific type of bakery item: a pastry.
 * This class extends the general {@code BakeryItem} class to include details
 * about the type of pastry and its quantity.
 */
public class Pastry extends BakeryItem {

    private BakeryEnum.PastryOptions typeOfItem;

    /**
     * Constructs a new {@code Pastry} object with the specified type and quantity.
     *
     * @param typeOfItem the specific type of pastry as defined in {@code BakeryEnum.PastryOptions}
     * @param quantity   the number of pastries being purchased
     */
    public Pastry(BakeryEnum.PastryOptions typeOfItem, int quantity) {
        super(BakeryEnum.PASTRY, quantity);
        this.typeOfItem = typeOfItem;
    }

    /**
     * Gets the type of pastry for this pastry item.
     *
     * @return the type of pastry as a {@code BakeryEnum.PastryOptions}
     */
    public BakeryEnum.PastryOptions getTypeOfItem() {
        return typeOfItem;
    }

    /**
     * Gets the quantity of pastries.
     *
     * @return the number of pastries
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates the total price of the pastry purchase.
     * The total price is determined by multiplying the unit price of the pastry type
     * by the quantity purchased.
     *
     * @return the total price for this pastry purchase
     */
    public double calculateTotalPrice() {
        return typeOfItem.getValue() * getQuantity();
    }

    /**
     * Returns a string representation of the pastry purchase.
     *
     * @return a string containing the description of the pastry type and the quantity
     */
    @Override
    public String toString() {
        return "Item: " + typeOfItem.getDescription() + ". Quantity: " + quantity;
    }
}
