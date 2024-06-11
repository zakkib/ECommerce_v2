class PaymentState implements CheckoutState {
    @Override
    public void proceed(CheckoutProcess context) {
        context.setState(new ConfirmationState());
        System.out.println("Proceeding to confirmation.");
    }

    @Override
    public void cancel(CheckoutProcess context) {
        context.setState(new CancelledState());
        System.out.println("Checkout cancelled.");
    }

    @Override
    public String getStateName() {
        return "Payment";
    }
}