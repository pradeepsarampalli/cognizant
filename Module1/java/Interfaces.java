interface Playable{
    public void play();
}
class Guitar implements Playable{
    @Override
    public void play() {
        System.out.println("Playing the guitar");
    }
}
class Piano implements Playable{
    @Override
    public void play() {
        System.out.println("Playing the piano");
    }
}
public class Interfaces {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }
}