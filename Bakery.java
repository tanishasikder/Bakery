import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a bakery that allows customers to select and purchase baked goods.
 * Customers can choose from various items like bread, cake, pastries, cookies, and pies,
 * and checkout or exit the application.
 */
public class Bakery {
    
    ArrayList<BakeryItem> shoppingCart = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    double collectedPrice = 0.0;

    /**
     * Main buying process where the user selects items or actions to perform.
     * Displays a menu of options and processes the user's input until they exit or checkout.
     */
    public void buying() {
        boolean loop = true;

        while(loop) {
            System.out.println("Select your purchase below");
            System.out.println("Bread\nCake\nPastry");   
            System.out.println("Cookie\nPie\nCheckout\nExit");
            System.out.println();

            String option = scan.next();
            scan.nextLine();

            if (option.equalsIgnoreCase("bread")) {
                breadMethod();
            } else if (option.equalsIgnoreCase("cake")) {
                cakeMethod();
            } else if (option.equalsIgnoreCase("pastry")) {
                pastryMethod();
            } else if (option.equalsIgnoreCase("cookie")) {
                cookieMethod();
            } else if (option.equalsIgnoreCase("pie")) {
                pieMethod();
            } else if (option.equalsIgnoreCase("checkout")) {
                loop = checkOut();
            } else if (option.equalsIgnoreCase("exit")) {
                exit();
            } else {
                System.out.println("\nInvalid Input. Try Again");
            } 
        }
    }

    /**
     * Handles the process of selecting and purchasing bread.
     * Displays bread options, takes user input, calculates the price, and adds the item to the cart.
     */
    public void breadMethod() {
        while (true) {
            try {
                System.out.println("\nSelect Type of Bread\n");
            
                for (BakeryEnum.BreadOptions bread : BakeryEnum.BreadOptions.values()) {
                    System.out.println(bread.getDescription() + ", $" + bread.getValue());
                }
                System.out.println();
                String breadKind = scan.nextLine();
                System.out.println("\nHow Many Would You Like?\n");
                int quantity = scan.nextInt();
                scan.nextLine();

                BakeryEnum.BreadOptions selectedBread = BakeryEnum.BreadOptions.
                    getBreadDescription(breadKind);
                
                double price = selectedBread.calculatePrice(quantity);
                collectedPrice += price;
                selectedBread.setValue(price);
                BreadLoaf purchase = new BreadLoaf(selectedBread, quantity);
                shoppingCart.add(purchase);
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

     /**
     * Handles the process of selecting and purchasing cake.
     * Displays cake options, takes user input for cake, frosting, and filling,
     * calculates the price, and adds the item to the cart.
     */
    public void cakeMethod() {
        while (true) {
            try {
                System.out.println("\nSelect Type of Cake\n");

                for (BakeryEnum.CakeOptions cake : BakeryEnum.CakeOptions.values()) {
                    System.out.println(cake.getDescription() + ", $" + cake.getValue());    
                }
                System.out.println();
                String cakeKind = scan.nextLine();
                BakeryEnum.CakeOptions selectedCake = BakeryEnum.CakeOptions.
                getCakeDescription(cakeKind);

                BakeryEnum.FrostingOptions selectedFrosting = frostingMethod();
                BakeryEnum.FillingOptions selectedFilling = fillingMethod();

                Cake purchase = cakeConstruct(selectedCake, selectedFrosting, 
                    selectedFilling);

                shoppingCart.add(purchase);
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

    /**
     * Constructs a cake with the specified options and calculates the total price.
     *
     * @param cake the selected cake option
     * @param frosting the selected frosting option
     * @param filling the selected filling option
     * @return a {@code Cake} object representing the purchase
     */
    public Cake cakeConstruct(BakeryEnum.CakeOptions cake, BakeryEnum.FrostingOptions frosting,
        BakeryEnum.FillingOptions filling) {

        System.out.println("\nHow Many Layers is the Cake?\n");
        int layers = scan.nextInt();

        System.out.println("\nHow Many Cakes?\n");
        int quantity = scan.nextInt();
        double cakePrice = cake.calculatePrice(layers);
        double frostingPrice = frosting.calculatePrice(layers);
        double fillingPrice = filling.calculatePrice(layers);
        double finalPrice = (cakePrice + frostingPrice + fillingPrice) * quantity;
        collectedPrice += finalPrice;
        cake.setValue(finalPrice);

        Cake purchase = new Cake(cake, frosting, filling, quantity, layers);

        return purchase;
    }

    /**
     * Handles the process of selecting frosting for a cake.
     *
     * @return the selected frosting option
     */
    public BakeryEnum.FrostingOptions frostingMethod() {
        while (true) {
            try {
                System.out.println("\nSelect Type of Frosting\n");

                for (BakeryEnum.FrostingOptions frosting : BakeryEnum.FrostingOptions.values()) {
                    System.out.println(frosting.getDescription() + ", $" + frosting.getValue());    
                }
                System.out.println();
                String frostingKind = scan.nextLine();
                
                BakeryEnum.FrostingOptions selectedFrosting = BakeryEnum.FrostingOptions.
                    getFrostingDescription(frostingKind);

                return selectedFrosting;
            } catch (Exception e) {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

    /**
     * Handles the process of selecting filling for a cake.
     *
     * @return the selected filling option
     */
    public BakeryEnum.FillingOptions fillingMethod() {
        while (true) {
            try {
                System.out.println("\nSelect Type of Filling\n");

                for (BakeryEnum.FillingOptions filling : BakeryEnum.FillingOptions.values()) {
                    System.out.println(filling.getDescription() + ", $" + filling.getValue());    
                }
                System.out.println();
                String fillingKind = scan.nextLine();
                BakeryEnum.FillingOptions selectedFilling = BakeryEnum.FillingOptions.
                    getFillingDescription(fillingKind);
                
                return selectedFilling;
            } catch (Exception e) {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

    /**
     * Handles the process of selecting and purchasing pastries.
     */
    public void pastryMethod() {
        while (true) {
            try {
                System.out.println("\nSelect Type of Pastry\n");

                for (BakeryEnum.PastryOptions pastry : BakeryEnum.PastryOptions.values()) {
                    System.out.println(pastry.getDescription() + ", $" + pastry.getValue());    
                }
                System.out.println();
                String pastryKind = scan.nextLine();
                System.out.println("\nHow Many Would You Like?\n");
                int quantity = scan.nextInt();
                scan.nextLine();

                BakeryEnum.PastryOptions selectedPastry = BakeryEnum.PastryOptions.
                    getPastryDescription(pastryKind);
                double price = selectedPastry.calculatePrice(quantity);
                collectedPrice += price;
                selectedPastry.setValue(price);
                Pastry purchase = new Pastry(selectedPastry, quantity);
                shoppingCart.add(purchase); 
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

    /**
     * Handles the process of selecting and purchasing cookies.
     */
    public void cookieMethod() {
        while (true) {
            try {
                System.out.println("\nSelect Type of Cookie\n");

                for (BakeryEnum.CookieOptions cookie : BakeryEnum.CookieOptions.values()) {
                    System.out.println(cookie.getDescription() + ", $" + cookie.getValue());    
                }
                System.out.println();
                String cookieKind = scan.nextLine();
                System.out.println("\nHow Many Would You Like?\n");
                int quantity = scan.nextInt();
                scan.nextLine();

                BakeryEnum.CookieOptions selectedCookie = BakeryEnum.CookieOptions.
                    getCookieDescription(cookieKind);
                double price = selectedCookie.calculatePrice(quantity);
                selectedCookie.setValue(price);
                collectedPrice += price;
                Cookie purchase = new Cookie(selectedCookie, quantity);
                shoppingCart.add(purchase);
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

    /**
     * Handles the process of selecting and purchasing pies.
     */
    public void pieMethod() {
        while (true) { 
            try {
                System.out.println("\nSelect Type of Pie\n");

                for (BakeryEnum.PieOptions pie : BakeryEnum.PieOptions.values()) {
                    System.out.println(pie.getDescription() + ", $" + pie.getValue());    
                }
                System.out.println();
                String pieKind = scan.nextLine();
                System.out.println("\nHow Many Would You Like?\n");
                int quantity = scan.nextInt();
                scan.nextLine();

                BakeryEnum.PieOptions selectedPie = BakeryEnum.PieOptions.
                    getPieDescription(pieKind);
                double price = selectedPie.calculatePrice(quantity);
                collectedPrice += price;
                selectedPie.setValue(price);
                Pie purchase = new Pie(selectedPie, quantity);
                shoppingCart.add(purchase);
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

    /**
     * Handles the checkout process where the total price is displayed, 
     * and the user can confirm or go back to continue shopping.
     * 
     * @return false if the user confirms checkout, true if they want to continue shopping.
     */
    public boolean checkOut() {
        while (true) {
            System.out.println("\nYour Selected Items are: ");
            for (BakeryItem items : shoppingCart) {
                System.out.println(items);  
            }
            System.out.println("\nDo You Wish to Continue? (Yes/No)\n");
            String wish = scan.next();

            if (wish.equalsIgnoreCase("yes")) {
                System.out.printf("\nTotal Price For Today: $%.2f", collectedPrice);   
                return false;   
            } else if (wish.equalsIgnoreCase("no")){
                System.out.println("\nWould You Like to Cancel the Purchase? (Yes/No)\n");
                String input = scan.next();
                scan.nextLine();

                if (input.equalsIgnoreCase("yes")) {
                    exit();
                    return false;
                } 
            } else {
                System.out.println("\nInvalid Input. Try Again");
            }
        }
    }

    /**
     * Exits the application.
     */
    public void exit() {
        System.out.println("\nThank You. Have a Nice Day!");
    }
    
    /**
     * Main method that prints a welcome statement then processes the application.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Bakery!\n");   
        Bakery b = new Bakery();
        b.buying(); 
    }
}
