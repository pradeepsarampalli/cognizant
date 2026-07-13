public class MobileApp implements Observer{

    @Override
    public void update(int value) {
       System.out.println("Value : "+value);
    }
    
}