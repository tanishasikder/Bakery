/**
 * Enum representing different bakery categories, such as breads, cakes, pastries, pies, cookies, frostings, and fillings.
 * Each enum type holds an array of available options for each category, with their associated prices.
 */
public enum BakeryEnum {

    /**
     * Bread category options with different bread types.
     */
    BREADLOAF(new BreadOptions[] {BreadOptions.WHITE, BreadOptions.SOURDOUGH, 
        BreadOptions.GLUTEN_FREE, BreadOptions.WHOLE_WHEAT, BreadOptions.SWEET_HAWAIIAN}), 

    /**
     * Cake category options with different cake types.
     */
    CAKE(new CakeOptions[] {CakeOptions.VANILLA, CakeOptions.CHOCOLATE, 
        CakeOptions.RED_VELVET, CakeOptions.MARBLE, CakeOptions.STRAWBERRY, 
        CakeOptions.CARAMEL, CakeOptions.CARROT, CakeOptions.FUNFETTI}),

    /**
     * Frosting category options with different frosting types.
     */
    FROSTING(new FrostingOptions[] {FrostingOptions.VANILLA, FrostingOptions.CHOCOLATE,
        FrostingOptions.COOKIES_N_CREME, FrostingOptions.CARAMEL, FrostingOptions.STRAWBERRY,
        FrostingOptions.CREAM_CHEESE, FrostingOptions.FUNFETTI, FrostingOptions.LEMON,
        FrostingOptions.COCONUT_CREAM, FrostingOptions.WHIPPED_CREAM}),
        
    /**
     * Filling category options with different filling types.
     */
    FILLING(new FillingOptions[] {FillingOptions.VANILLA_CUSTARD, FillingOptions.CHOCOLATE_CREAM,
        FillingOptions.STRAWBERRIES, FillingOptions.RASPBERRIES, FillingOptions.BLUEBERRIES,
        FillingOptions.BLACKBERRIES, FillingOptions.LEMON_CUSTARD, FillingOptions.CARAMEL,
        FillingOptions.OREOS, FillingOptions.WHIPPED_CREAM}),

    /**
     * Pastry category options with different pastry types.
     */
    PASTRY(new PastryOptions[] {PastryOptions.CROISSANT, PastryOptions.CHEESE_DANISH, 
        PastryOptions.SAUSAGE_ROLL, PastryOptions.CHOCOLATE_ROLL, PastryOptions.STRAWBERRY_ROLL, 
        PastryOptions.ECLAIR, PastryOptions.CREAM_ROLL, PastryOptions.CINNAMON_ROLL}), 

    /**
     * Pie category options with different pie types.
     */
    PIE(new PieOptions[] {PieOptions.CHERRY, PieOptions.BLUEBERRY, PieOptions.COOKIES_N_CREME, 
        PieOptions.APPLE, PieOptions.KEYLIME, PieOptions.CHOCOLATE_CREAM, PieOptions.PECAN}), 

    /**
     * Cookie category options with different cookie types.
     */
    COOKIE(new CookieOptions[] {CookieOptions.SUGAR, CookieOptions.CHOCOLATE_CHIP, 
        CookieOptions.DOUBLE_CHOCOLATE, CookieOptions.MM, CookieOptions.FROSTED_SUGAR, 
        CookieOptions.OATMEAL_RAISIN});
     
    /**
     * Array of options available in each category.
     */
    private final Enum<?>[] options;
    
    /**
     * Constructor to initialize the BakeryEnum with the corresponding options.
     * @param options The array of options available in the bakery category.
     */
    BakeryEnum(Enum<?>[] options) {
        this.options = options;
    }

    /**
     * Enum for the different bread options available.
     */
    public enum BreadOptions {
        WHITE("White Bread", 7.99), 
        SOURDOUGH("Sourdough Bread", 9.99), 
        GLUTEN_FREE("Gluten Free Bread", 11.99), 
        WHOLE_WHEAT("Whole Wheat Bread", 6.99), 
        SWEET_HAWAIIAN("Sweet Hawaiian Bread", 8.50);

        private final String description; 
        private double value;

        /**
         * Constructor to initialize bread options with description and price.
         * @param description The description of the bread.
         * @param value The price of the bread.
         */
        BreadOptions(String description, double value) {
            this.description = description;
            this.value = value;
        }

        /**
         * Gets the description of the bread.
         * @return The description of the bread.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Gets the price of the bread.
         * @return The price of the bread.
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the price of the bread.
         * @param value The new price of the bread.
         */
        public void setValue(double value) {
            this.value = value; 
        }

        /**
         * Gets the bread option by description.
         * @param description The description of the bread to search for.
         * @return The bread option corresponding to the description.
         * @throws IllegalArgumentException if no matching bread option is found.
         */
        public static BakeryEnum.BreadOptions getBreadDescription(String description) {
            for (BreadOptions option : BreadOptions.values()) {
                if (option.getDescription().equalsIgnoreCase(description)) {
                    return option;
                }
            }
            throw new IllegalArgumentException("No bread found with: " + description);
        }

        /**
         * Calculates the price based on the quantity of bread.
         * @param quantity The quantity of bread.
         * @return The total price for the specified quantity of bread.
         */
        public double calculatePrice(int quantity) {
            return this.getValue() * quantity;                           
        }
    }

    /**
     * Enum for the different cake options available.
     */
    public enum CakeOptions {
        VANILLA("Vanilla Cake", 7.99), 
        CHOCOLATE("Chocolate Cake", 8.99), 
        RED_VELVET("Red Velvet Cake", 9.99), 
        MARBLE("Marble Cake", 8.99), 
        STRAWBERRY("Strawberry Cake", 6.99), 
        CARAMEL("Caramel Cake", 9.99),
        CARROT("Carrot Cake", 8.99), 
        FUNFETTI("Funfetti Cake", 8.99);

        private final String description; 
        private double value;

        /**
         * Constructor to initialize cake options with description and price.
         * @param description The description of the cake.
         * @param value The price of the cake.
         */
        CakeOptions(String description, double value) {
            this.description = description;
            this.value = value;
        }

        /**
         * Gets the description of the cake.
         * @return The description of the cake.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Gets the price of the cake.
         * @return The price of the cake.
         */
        public double getValue() {
            return value;
        }
        
        /**
         * Sets the price of the cake.
         * @param value The new price of the cake.
         */
        public void setValue(double value) {
            this.value = value; 
        }

        /**
         * Gets the cake option by description.
         * @param description The description of the cake to search for.
         * @return The cake option corresponding to the description.
         * @throws IllegalArgumentException if no matching cake option is found.
         */
        public static CakeOptions getCakeDescription(String description) {
            for (CakeOptions option : CakeOptions.values()) {
                if (option.getDescription().equalsIgnoreCase(description)) {
                    return option;
                }
            }
            throw new IllegalArgumentException("No cake found with: " + description);
        }

        /**
         * Calculates the price based on the quantity of cake.
         * @param quantity The quantity of cake.
         * @return The total price for the specified quantity of cake.
         */
        public double calculatePrice(int quantity) {
            return this.getValue() * quantity;                           
        }
    }

    /**
     * Enum for the different pastry options available.
     */
    public enum PastryOptions {
        CROISSANT("Croissant", 3.50), 
        CHEESE_DANISH("Cheese Danish", 2.99), 
        SAUSAGE_ROLL("Sausage Roll", 4.50), 
        CHOCOLATE_ROLL("Chocolate Roll", 3.99), 
        STRAWBERRY_ROLL("Strawberry Roll", 3.50), 
        ECLAIR("Eclair", 3.99), 
        CREAM_ROLL("Cream Roll", 3.50), 
        CINNAMON_ROLL("Cinnamon Roll", 3.99);

        private final String description; 
        private double value;

        /**
         * Constructor to initialize pastry options with description and price.
         * @param description The description of the pastry.
         * @param value The price of the pastry.
         */
        PastryOptions(String description, double value) {
            this.description = description;
            this.value = value;
        }

        /**
         * Gets the description of the pastry.
         * @return The description of the pastry.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Gets the price of the pastry.
         * @return The price of the pastry.
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the price of the pastry.
         * @param value The new price of the pastry.
         */
        public void setValue(double value) {
            this.value = value; 
        }

        /**
         * Gets the pastry option by description.
         * @param description The description of the pastry to search for.
         * @return The pastry option corresponding to the description.
         * @throws IllegalArgumentException if no matching pastry option is found.
         */
        public static PastryOptions getPastryDescription(String description) {
            for (PastryOptions option : PastryOptions.values()) {
                if (option.getDescription().equalsIgnoreCase(description)) {
                    return option;
                }
            }
            throw new IllegalArgumentException("No pastry found with: " + description);
        }

        /**
         * Calculates the price based on the quantity of pastry.
         * @param quantity The quantity of pastry.
         * @return The total price for the specified quantity of pastry.
         */
        public double calculatePrice(int quantity) {
            return this.getValue() * quantity;                           
        }
    }


    /**
     * Enum representing different pie options with descriptions and prices.
     */
    public enum PieOptions {
        CHERRY("Cherry Pie", 12.99), 
        BLUEBERRY("Blueberry Pie", 12.99), 
        COOKIES_N_CREME("Cookies N Creme Pie", 14.99), 
        APPLE("Apple Pie", 13.99), 
        KEYLIME("Keylime Pie", 11.99), 
        PECAN("Pecan Pie", 12.99),
        CHOCOLATE_CREAM("Chocolate Cream Pie", 11.50);

        private final String description; 
        private double value;

        /**
         * Constructor for PieOptions.
         * 
         * @param description The description of the pie option.
         * @param value The price of the pie.
         */
        PieOptions(String description, double value) {
            this.description = description;
            this.value = value;
        }

        /**
         * Gets the description of the pie.
         * 
         * @return The description of the pie.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Gets the price of the pie.
         * 
         * @return The price of the pie.
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the price of the pie.
         * 
         * @param value The price to set.
         */
        public void setValue(double value) {
            this.value = value; 
        }

        /**
         * Retrieves the PieOptions enum value by description.
         * 
         * @param description The description of the pie.
         * @return The PieOptions corresponding to the description.
         * @throws IllegalArgumentException if no pie is found with the given description.
         */
        public static PieOptions getPieDescription(String description) {
            for (PieOptions option : PieOptions.values()) {
                if (option.getDescription().equalsIgnoreCase(description)) {
                    return option;
                }
            }
            throw new IllegalArgumentException("No pie found with: " + description);
        }

        /**
         * Calculates the price based on the quantity of pies.
         * 
         * @param quantity The number of pies.
         * @return The total price for the specified quantity of pies.
         */
        public double calculatePrice(int quantity) {
            return this.getValue() * quantity;                            
        }
    }

    /**
     * Enum representing different cookie options with descriptions and prices.
     */
    public enum CookieOptions {
        SUGAR("Sugar Cookie", 2.50), 
        CHOCOLATE_CHIP("Chocolate Chip Cookie", 3.50), 
        DOUBLE_CHOCOLATE("Double Chocolate Cookie", 3.50), 
        MM("M&M Cookie", 2.99), 
        FROSTED_SUGAR("Frosted Sugar Cookie", 2.99),
        OATMEAL_RAISIN("Oatmeal Raisin Cookie", 2.50);

        private final String description; 
        private double value;

        /**
         * Constructor for CookieOptions.
         * 
         * @param description The description of the cookie.
         * @param value The price of the cookie.
         */
        CookieOptions(String description, double value) {
            this.description = description;
            this.value = value;
        }

        /**
         * Gets the description of the cookie.
         * 
         * @return The description of the cookie.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Gets the price of the cookie.
         * 
         * @return The price of the cookie.
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the price of the cookie.
         * 
         * @param value The price to set.
         */
        public void setValue(double value) {
            this.value = value; 
        }

        /**
         * Retrieves the CookieOptions enum value by description.
         * 
         * @param description The description of the cookie.
         * @return The CookieOptions corresponding to the description.
         * @throws IllegalArgumentException if no cookie is found with the given description.
         */
        public static CookieOptions getCookieDescription(String description) {
            for (CookieOptions option : CookieOptions.values()) {
                if (option.getDescription().equalsIgnoreCase(description)) {
                    return option;
                }
            }
            throw new IllegalArgumentException("No cookie found with: " + description);
        }

        /**
         * Calculates the price based on the quantity of cookies.
         * 
         * @param quantity The number of cookies.
         * @return The total price for the specified quantity of cookies.
         */
        public double calculatePrice(int quantity) {
            return this.getValue() * quantity;                            
        }
    }

    /**
     * Enum representing different frosting options with descriptions and prices.
     */
    public enum FrostingOptions {
        VANILLA("Vanilla Frosting", 5.99), 
        CHOCOLATE("Chocolate Frosting", 7.99), 
        COOKIES_N_CREME("Cookies N Creme Frosting", 8.99), 
        CARAMEL("Caramel Frosting", 7.99), 
        STRAWBERRY("Frosting Frosting", 5.99),
        CREAM_CHEESE("Cream Cheese Frosting", 4.99), 
        FUNFETTI("Funfetti Frosting", 6.99), 
        LEMON("Lemon Frosting", 5.99), 
        COCONUT_CREAM("Coconut Cream Frosting", 6.99), 
        WHIPPED_CREAM("Whipped Cream", 4.99);

        private final String description; 
        private double value;

        /**
         * Constructor for FrostingOptions.
         * 
         * @param description The description of the frosting.
         * @param value The price of the frosting.
         */
        FrostingOptions(String description, double value) {
            this.description = description;
            this.value = value;
        }

        /**
         * Gets the description of the frosting.
         * 
         * @return The description of the frosting.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Gets the price of the frosting.
         * 
         * @return The price of the frosting.
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the price of the frosting.
         * 
         * @param value The price to set.
         */
        public void setValue(double value) {
            this.value = value; 
        }

        /**
         * Calculates the price based on the quantity of frosting.
         * 
         * @param quantity The number of frostings.
         * @return The total price for the specified quantity of frosting.
         */
        public double calculatePrice(int quantity) {
            return this.getValue() * quantity;                            
        }

        /**
         * Retrieves the FrostingOptions enum value by description.
         * 
         * @param description The description of the frosting.
         * @return The FrostingOptions corresponding to the description.
         * @throws IllegalArgumentException if no frosting is found with the given description.
         */
        public static FrostingOptions getFrostingDescription(String description) {
            for (FrostingOptions option : FrostingOptions.values()) {
                if (option.getDescription().equalsIgnoreCase(description)) {
                    return option;
                }
            }
            throw new IllegalArgumentException("No frosting found with: " + description);
        }
    }


    /**
     * Enum representing different filling options with descriptions and prices.
     */
    public enum FillingOptions {
        VANILLA_CUSTARD("Vanilla Custard", 7.50), 
        CHOCOLATE_CREAM("Chocolate Cream", 8.50), 
        STRAWBERRIES("Strawberries", 8.00), 
        RASPBERRIES("Raspberries", 9.00), 
        BLUEBERRIES("Blueberries", 7.00), 
        BLACKBERRIES("Blackberries", 8.00), 
        LEMON_CUSTARD("Lemon Custard", 10.99), 
        CARAMEL("Caramel", 9.99), 
        OREOS("Oreos", 7.99),
        WHIPPED_CREAM("Whipped Cream", 6.99);

        private final String description;
        private double value; 

        /**
         * Constructor for FillingOptions.
         * 
         * @param description The description of the filling.
         * @param value The price of the filling.
         */
        FillingOptions(String description, double value) {
            this.description = description;
            this.value = value;
        }

        /**
         * Gets the description of the filling.
         * 
         * @return The description of the filling.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Gets the price of the filling.
         * 
         * @return The price of the filling.
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the price of the filling.
         * 
         * @param value The price to set.
         */
        public void setValue(double value) {
            this.value = value; 
        }

        /**
         * Calculates the price based on the quantity of fillings.
         * 
         * @param quantity The number of fillings.
         * @return The total price for the specified quantity of fillings.
         */
        public double calculatePrice(int quantity) {
            return this.getValue() * quantity;                            
        }

        /**
         * Retrieves the FillingOptions enum value by description.
         * 
         * @param description The description of the filling.
         * @return The FillingOptions corresponding to the description.
         * @throws IllegalArgumentException if no filling is found with the given description.
         */
        public static FillingOptions getFillingDescription(String description) {
            for (FillingOptions option : FillingOptions.values()) {
                if (option.getDescription().equalsIgnoreCase(description)) {
                    return option;
                }
            }
            throw new IllegalArgumentException("No filling found with: " + description);
        }
    }
}
