class ShippingState implements CheckoutState {
    @Override
    public void proceed(CheckoutProcess context) {
        context.setState(new PaymentState());
        System.out.println("Proceeding to payment.");
    }

    @Override
    public void cancel(CheckoutProcess context) {
        context.setState(new CancelledState());
        System.out.println("Checkout cancelled.");
    }

    @Override
    public String getStateName() {
        return "Shipping";
    }
}