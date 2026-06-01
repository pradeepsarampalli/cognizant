import java.util.ArrayList;
public class LambdaEx {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("pradeep");
        names.add("suresh");
        names.add("ramesh");
        names.add("mahesh");

        names.sort((a,b)->a.compareTo(b));
        System.out.println("Sorted names: " + names);
    }
}