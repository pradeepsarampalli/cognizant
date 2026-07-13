public class RealImage implements Image{
    String fileName;
    public RealImage(String fileName){
        this.fileName=fileName;
        loadImageFromDisk();
    }

    public void loadImageFromDisk(){
        System.out.println("Loading image from disk!");
    }
    @Override
    public void display() {
      System.out.println("Displaying Image : "+this.fileName);
    }
    
}