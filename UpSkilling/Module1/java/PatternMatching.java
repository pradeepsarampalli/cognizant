import java.util.Scanner;

public class PatternMatching {

    public void printType(Object obj){
        if(obj instanceof String){
            String s = (String) obj;
            System.out.println("It's a String: "+s);
        }
        else if(obj instanceof Integer){
            Integer i = (Integer) obj;
            System.out.println("It's an Integer: "+i);
        }
        else if(obj instanceof Double){
            Double d = (Double) obj;
            System.out.println("It's a Double: "+d);
        }
        else{
            System.out.println("Unknown type");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value: ");
        Object input = sc.next();
        PatternMatching pm = new PatternMatching();
        pm.printType(input);
        input = sc.nextInt();
        pm.printType(input);
        input = sc.nextDouble();
        pm.printType(input);
        sc.close();
    }
    
}

