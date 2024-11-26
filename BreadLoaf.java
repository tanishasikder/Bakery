/**
 * Represents a specific type of bakery item: a bread loaf.
 * This class extends the general {@code BakeryItem} class to include details
 * about the type of bread and its quantity.
 */
public class BreadLoaf extends BakeryItem {

    private BakeryEnum.BreadOptions typeOfItem;

     /**
     * Constructs a new {@code BreadLoaf} object with the specified type and quantity.
     *
     * @param typeOfItem the specific type of bread as defined in {@code BakeryEnum.BreadOptions}
     * @param quantity   the number of bread loaves being purchased
     */
    public BreadLoaf(BakeryEnum.BreadOptions typeOfItem, int quantity) {
        super(BakeryEnum.BREADLOAF, quantity);
        this.typeOfItem = typeOfItem;
    }

    /**
     * Gets the type of bread for this bread loaf.
     *
     * @return the type of bread as a {@code BakeryEnum.BreadOptions}
     */
    public BakeryEnum.BreadOptions getTypeOfItem() {
        return typeOfItem;
    }

    /**
     * Gets the quantity of bread loaves.
     *
     * @return the number of bread loaves
     */
    public int getQuantity() {
        return quantity;
    }

     /**
     * Sets the type of bread for this bread loaf.
     *
     * @param typeOfItem the specific type of bread as defined in {@code BakeryEnum.BreadOptions}
     */
    public void setTypeOfItem(BakeryEnum.BreadOptions typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    /**
     * Calculates the total price of the bread loaf purchase.
     * The total price is determined by multiplying the unit price of the bread type
     * by the quantity purchased.
     *
     * @return the total price for this bread loaf purchase
     */
    public double calculateTotalPrice() {
        return typeOfItem.getValue() * getQuantity();
    }

    /**
     * Returns a string representation of the bread loaf purchase.
     *
     * @return a string containing the description of the bread type and the quantity
     */
    @Override
    public String toString() {
        return "Item: " + typeOfItem.getDescription() + ". Quantity: " + quantity;
    }
}
