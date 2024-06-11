interface CheckoutState {
    void proceed(CheckoutProcess context);
    void cancel(CheckoutProcess context);
    String getStateName();
}