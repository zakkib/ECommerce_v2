class CheckoutObserver {
    private final String name;

    public CheckoutObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}