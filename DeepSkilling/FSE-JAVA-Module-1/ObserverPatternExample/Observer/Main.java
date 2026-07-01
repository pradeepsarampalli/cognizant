package Observer;

public class Main {
     static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();
        stockMarket.register(mobile);
        stockMarket.register(web);
        stockMarket.notifyObserver();
    }

}
