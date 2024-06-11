import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private final List<Product> products;
    private final List<CartObserver> observers;

    private ShoppingCart(Builder builder) {
        this.products = builder.products;
        this.observers = builder.observers;
    }

    public void addProduct(Product product) {
        products.add(product);
        notifyObservers(product.getName() + " added to cart.");
    }

    public void removeProduct(Product product) {
        products.remove(product);
        notifyObservers(product.getName() + " removed from cart.");
    }

    public void viewCart() {
        System.out.println("Shopping Cart:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    public void notifyObservers(String message) {
        for (CartObserver observer : observers) {
            observer.update(message);
        }
    }

    public static class Builder {
        private final List<Product> products = new ArrayList<>();
        private final List<CartObserver> observers = new ArrayList<>();

        public Builder addProduct(Product product) {
            products.add(product);
            return this;
        }

        public Builder removeProduct(Product product) {
            products.remove(product);
            return this;
        }

        public Builder addObserver(CartObserver observer) {
            observers.add(observer);
            return this;
        }

        public ShoppingCart build() {
            return new ShoppingCart(this);
        }
    }
}