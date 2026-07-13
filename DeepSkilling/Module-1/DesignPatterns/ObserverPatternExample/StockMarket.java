import java.util.*;

public class StockMarket implements Stock{
    List<Observer> observers = new ArrayList<>();
    int value;
    @Override
    public void register(Observer observer) {
      observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer ob : observers){
            ob.update(value);
        }
    }
    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}