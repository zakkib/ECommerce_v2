import java.util.HashMap;
import java.util.Map;

class ShoppingFacade {
    @SuppressWarnings("unused")
    private final ShoppingCart.Builder cartBuilder;
    private final CheckoutProcess checkoutProcess;
    private final Map<String, Product> productCatalog;
    private ShoppingCart cart;

    public ShoppingFacade(ShoppingCart.Builder cartBuilder, CheckoutProcess checkoutProcess) {
        this.cartBuilder = cartBuilder;
        this.checkoutProcess = checkoutProcess;
        this.productCatalog = new HashMap<>();
        this.cart = cartBuilder.build();
        initializeProductCatalog();
    }

    private void initializeProductCatalog() {
        productCatalog.put("P001", new Product("P001", "Laptop", 999.99));
        productCatalog.put("P002", new Product("P002", "Smartphone", 499.99));
    }

    public void browseProducts() {
        System.out.println("Product Catalog:");
        for (Product product : productCatalog.values()) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
    }

    public void addToCart(String productId) {
        Product product = productCatalog.get(productId);
        if (product != null) {
            cart.addProduct(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeFromCart(String productId) {
        Product product = productCatalog.get(productId);
        if (product != null) {
            cart.removeProduct(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void viewCart() {
        cart.viewCart();
    }

    public void checkout() {
        checkoutProcess.proceed();
    }

    public void proceed() {
        checkoutProcess.proceed();
    }

    public void cancel() {
        checkoutProcess.cancel();
    }
}