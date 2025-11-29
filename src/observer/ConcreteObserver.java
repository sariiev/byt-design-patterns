package observer;

public class ConcreteObserver implements Observer {
    private String username;
    private Subject subject;

    public ConcreteObserver(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void addSubscriber(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void removeSubscriber(Subject subject) {
        if (this.subject != null && this.subject == subject) {
            this.subject.removeObserver(this);
            this.subject = null;
        }
    }

    @Override
    public void update(String availability) {
        System.out.println(username + ", product is now " + availability);
    }
}
