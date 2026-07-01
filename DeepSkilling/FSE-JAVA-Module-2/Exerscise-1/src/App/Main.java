package App;

public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        Product p1 = new Product(101,"Laptop",10,50000);
        Product p2 = new Product(102,"Mobile",20,25000);

        manager.addProduct(p1);
        manager.addProduct(p2);

        System.out.println("After Adding:");
        manager.displayProducts();

        Product updated =
                new Product(101,"Laptop",15,52000);

        manager.updateProduct(updated);

        System.out.println("\nAfter Updating:");
        manager.displayProducts();

        manager.deleteProduct(102);

        System.out.println("\nAfter Deleting:");
        manager.displayProducts();
    }
}