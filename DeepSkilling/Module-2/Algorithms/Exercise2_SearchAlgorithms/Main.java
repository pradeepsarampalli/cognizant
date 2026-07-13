import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Product[] products={
            new Product(101,"Laptop","Electronics"),
            new Product(102,"Mouse","Electronics"),
            new Product(103,"Phone","Electronics"),
            new Product(104,"Shoes","Fashion")
        };

        System.out.println("Linear Search:");
        System.out.println(LinearSearch.search(products,"Phone"));

        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        System.out.println("\nBinary Search:");
        System.out.println(BinarySearch.search(products,"Phone"));
    }
}