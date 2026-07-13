public class Main {
    public static void main(String[] args) {
        StockMarket stk = new StockMarket();
        MobileApp mapp = new MobileApp();
        WebApp wapp = new WebApp();
        stk.register(wapp);
        stk.register(mapp);
        stk.setValue(1000);
        stk.setValue(2000);
    }
}