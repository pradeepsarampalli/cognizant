package Proxy;

public class ProxyImage implements Image {
    RealImage realimage;
    @Override
    public void display(){
        if(realimage == null){
            System.out.println("loading img for first time...");
            realimage = new RealImage("");
        }
        realimage.display();
    }

}
