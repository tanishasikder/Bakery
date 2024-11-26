/**
 * Represents a specific type of bakery item: a pie.
 * This class extends the general {@code BakeryItem} class to include details
 * about the type of pie and its quantity.
 */
public class Pie extends BakeryItem {

    private BakeryEnum.PieOptions typeOfItem;

    /**
     * Constructs a new {@code Pie} object with the specified type and quantity.
     *
     * @param typeOfItem the specific type of pie as defined in {@code BakeryEnum.PieOptions}
     * @param quantity   the number of pies being purchased
     */
    public Pie(BakeryEnum.PieOptions typeOfItem, int quantity) {
        super(BakeryEnum.PIE, quantity);
        this.typeOfItem = typeOfItem;
    }

    /**
     * Gets the type of pie for this pie item.
     *
     * @return the type of pie as a {@code BakeryEnum.PieOptions}
     */
    public BakeryEnum.PieOptions getTypeOfItem() {
        return typeOfItem;
    }

    /**
     * Gets the quantity of pies.
     *
     * @return the number of pies
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates the total price of the pie purchase.
     * The total price is determined by multiplying the unit price of the pie type
     * by the quantity purchased.
     *
     * @return the total price for this pie purchase
     */
    public double calculateTotalPrice() {
        return typeOfItem.getValue() * getQuantity();
    }

    /**
     * Returns a string representation of the pie purchase.
     *
     * @return a string containing the description of the pie type and the quantity
     */
    @Override
    public String toString() {
        return "Item: " + typeOfItem.getDescription() + ". Quantity: " + quantity;
    }
}
