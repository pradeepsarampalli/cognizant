package Proxy;

public class RealImage {
    public RealImage(String s) {
    }

    public void display() {
    }

    public class realImage implements Image {
        private String filename;
        realImage(String filename){
            this.filename = filename;
            loaddata();
        }
        public void loaddata(){
            System.out.println("The data is loading..."+filename);
        }
        @Override
        public void display(){
            System.out.println("This is RealImage Class"+filename);
        }
    }
}
