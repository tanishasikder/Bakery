/**
 * Represents a specific type of bakery item: a cake.
 * This class extends the general {@code BakeryItem} class to include details
 * about the cake's type, frosting, filling, layers, and quantity.
 */
public class Cake extends BakeryItem {

    protected int layers;
    private BakeryEnum.FrostingOptions frosting;
    private BakeryEnum.FillingOptions filling;
    private BakeryEnum.CakeOptions typeOfItem;

    /**
     * Constructs a new {@code Cake} object with the specified type, frosting, filling,
     * quantity, and layers.
     *
     * @param typeOfItem the specific type of cake as defined in {@code BakeryEnum.CakeOptions}
     * @param frosting   the frosting type for the cake as defined in {@code BakeryEnum.FrostingOptions}
     * @param filling    the filling type for the cake as defined in {@code BakeryEnum.FillingOptions}
     * @param quantity   the number of cakes being purchased
     * @param layers     the number of layers in the cake
     */
    public Cake(BakeryEnum.CakeOptions typeOfItem, BakeryEnum.FrostingOptions frosting, 
        BakeryEnum.FillingOptions filling, int quantity, int layers) {
        super(BakeryEnum.CAKE, quantity);
        this.typeOfItem = typeOfItem;
        this.frosting = frosting;
        this.filling = filling;
        this.layers = layers;
    }

    /**
     * Gets the type of cake for this cake item.
     *
     * @return the type of cake as a {@code BakeryEnum.CakeOptions}
     */
    public BakeryEnum.CakeOptions getTypeOfItem() {
        return typeOfItem;
    }

    /**
     * Gets the quantity of cakes.
     *
     * @return the number of cakes
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the type of cake for this cake item.
     *
     * @param typeOfItem the type of cake to set
     */
    public void setTypeOfItem(BakeryEnum.CakeOptions typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    /**
     * Calculates the total price of the cake purchase.
     * The total price is determined by multiplying the unit price of the cake type
     * by the quantity purchased.
     *
     * @return the total price for this cake purchase
     */
    public double calculateTotalPrice() {
        return typeOfItem.getValue() * getQuantity();
    }

    /**
     * Returns a string representation of the cake purchase, including details 
     * about the cake's type, frosting, filling, number of layers, and quantity.
     *
     * @return a string containing the description of the cake's type, frosting, 
     *         filling, number of layers, and quantity
     */
    @Override
    public String toString() {
        return "Item: " + typeOfItem.getDescription() + ", " + frosting.getDescription() + ", " + 
            filling.getDescription() + ", Layers: " + layers + ", Quantity: " + quantity;
    }
}
