package observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private final List<Observer> observerList = new ArrayList<>();

    private String productName;
    private int productPrice;
    private String availability;

    public ConcreteSubject(String productName, int productPrice, String availability) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.availability = availability;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
        System.out.println("Availability changed from Out of Stock to Available.");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        System.out.println("Observer Added: " + ((ConcreteObserver) observer).getUsername());
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        System.out.println("Observer Removed: " + ((ConcreteObserver) observer).getUsername());
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Product Name: "
                + productName + ", Product Price: "
                + productPrice + " is now available. Notifying all registered users.");
        System.out.println();

        for (Observer observer : observerList) {
            observer.update(availability);
        }
    }
}
