package Observer;

public class MobileApp implements  Observer{
    @Override
    public void update() {
        System.out.println("Mobile App received stock update");
    }
}
