class ConfirmationState implements CheckoutState {
    @Override
    public void proceed(CheckoutProcess context) {
        System.out.println("Checkout complete.");
    }

    @Override
    public void cancel(CheckoutProcess context) {
        context.setState(new CancelledState());
        System.out.println("Checkout cancelled.");
    }

    @Override
    public String getStateName() {
        return "Confirmation";
    }
}