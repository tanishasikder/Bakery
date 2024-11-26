/**
 * Represents a specific type of bakery item: a cookie.
 * This class extends the general {@code BakeryItem} class to include details
 * about the type of cookie and its quantity.
 */
public class Cookie extends BakeryItem {

    private BakeryEnum.CookieOptions typeOfItem;

    /**
     * Constructs a new {@code Cookie} object with the specified type and quantity.
     *
     * @param typeOfItem the specific type of cookie as defined in {@code BakeryEnum.CookieOptions}
     * @param quantity   the number of cookies being purchased
     */
    public Cookie(BakeryEnum.CookieOptions typeOfItem, int quantity) {
        super(BakeryEnum.COOKIE, quantity);
        this.typeOfItem = typeOfItem;
    }

    /**
     * Gets the type of cookie for this cookie item.
     *
     * @return the type of cookie as a {@code BakeryEnum.CookieOptions}
     */
    public BakeryEnum.CookieOptions getTypeOfItem() {
        return typeOfItem;
    }

    /**
     * Gets the quantity of cookies.
     *
     * @return the number of cookies
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the type of cookie for this cookie item.
     *
     * @param typeOfItem the specific type of cookie as defined in {@code BakeryEnum.CookieOptions}
     */
    public void setTypeOfItem(BakeryEnum.CookieOptions typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    /**
     * Calculates the total price of the cookie purchase.
     * The total price is determined by multiplying the unit price of the cookie type
     * by the quantity purchased.
     *
     * @return the total price for this cookie purchase
     */
    public double calculateTotalPrice() {
        return typeOfItem.getValue() * getQuantity();
    }

    /**
     * Returns a string representation of the cookie purchase.
     *
     * @return a string containing the description of the cookie type and the quantity
     */
    @Override
    public String toString() {
        return "Item: " + typeOfItem.getDescription() + ". Quantity: " + quantity;
    }
}
