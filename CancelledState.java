class CancelledState implements CheckoutState {
    @Override
    public void proceed(CheckoutProcess context) {
        System.out.println("Cannot proceed. Checkout is cancelled.");
    }

    @Override
    public void cancel(CheckoutProcess context) {
        System.out.println("Already cancelled.");
    }

    @Override
    public String getStateName() {
        return "Cancelled";
    }
}