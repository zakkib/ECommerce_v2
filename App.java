import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CartObserver cartObserver = new CartObserver("CartObserver");
        CheckoutObserver checkoutObserver = new CheckoutObserver("CheckoutObserver");

        ShoppingCart.Builder cartBuilder = new ShoppingCart.Builder().addObserver(cartObserver);
        CheckoutProcess checkoutProcess = new CheckoutProcess().addObserver(checkoutObserver);
        ShoppingFacade facade = new ShoppingFacade(cartBuilder, checkoutProcess);

        System.out.println("Welcome to the E-commerce Shopping Cart System!");
        System.out.println("Available commands: browse, add <product_id>, remove <product_id>, view_cart, checkout, proceed, cancel, exit");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            String action = parts[0];

            if (action.equals("browse")) {
                facade.browseProducts();
            } else if (action.equals("add") && parts.length > 1) {
                facade.addToCart(parts[1]);
            } else if (action.equals("remove") && parts.length > 1) {
                facade.removeFromCart(parts[1]);
            } else if (action.equals("view_cart")) {
                facade.viewCart();
            } else if (action.equals("checkout")) {
                facade.checkout();
            } else if (action.equals("proceed")) {
                facade.proceed();
            } else if (action.equals("cancel")) {
                facade.cancel();
            } else if (action.equals("exit")) {
                System.out.println("Thank you for using the E-commerce Shopping Cart System. Goodbye!");
                break;
            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }
}