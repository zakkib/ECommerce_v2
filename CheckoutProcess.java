import java.util.ArrayList;
import java.util.List;

class CheckoutProcess {
    private CheckoutState state;
    private final List<CheckoutObserver> observers;

    public CheckoutProcess() {
        this.state = new ShippingState();
        this.observers = new ArrayList<>();
    }

    public void setState(CheckoutState state) {
        this.state = state;
        notifyObservers("Checkout state changed to " + state.getStateName());
    }

    public void proceed() {
        state.proceed(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public CheckoutProcess addObserver(CheckoutObserver observer) {
        observers.add(observer);
        return this;
    }

    public void notifyObservers(String message) {
        for (CheckoutObserver observer : observers) {
            observer.update(message);
        }
    }
}