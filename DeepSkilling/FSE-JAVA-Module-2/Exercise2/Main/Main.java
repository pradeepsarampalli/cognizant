package Exercise2.Main;



public class Main {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101,"Laptop","Electronics"),
                new Product(102,"Mobile","Electronics"),
                new Product(103,"Mouse","Accessories"),
                new Product(104,"Keyboard","Accessories"),
                new Product(105,"Monitor","Electronics")
        };

        System.out.println(
                SearchOperations.linearSearch(products,103)
        );

        System.out.println(
                SearchOperations.binarySearch(products,103)
        );
    }
}
