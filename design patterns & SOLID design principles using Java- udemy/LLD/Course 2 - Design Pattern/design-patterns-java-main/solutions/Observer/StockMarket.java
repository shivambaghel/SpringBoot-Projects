package Observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Subject {
    
    private final List<Observer> observers;
    private final double priceChangeThreshold;

    public StockMarket(double priceChangeThreshold) {
        this.observers = new ArrayList<>();
        this.priceChangeThreshold = priceChangeThreshold;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String stockSymbol, double newPrice) {
        for (Observer observer : observers) {
            observer.update(stockSymbol, newPrice);
        }
    }

    public void setStockPrice(String stockSymbol, double newPrice, double oldPrice) {
        double priceChange = Math.abs(newPrice - oldPrice) / oldPrice * 100;
        if (priceChange >= priceChangeThreshold) {
            notifyObservers(stockSymbol, newPrice);
        }
    }
}