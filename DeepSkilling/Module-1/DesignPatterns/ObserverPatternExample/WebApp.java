public class WebApp implements Observer{
    @Override
    public void update(int value) {
       System.out.println("Value :"+value);
    }
    
}