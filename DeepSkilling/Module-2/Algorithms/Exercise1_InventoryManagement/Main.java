public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for(int i=1;i<=5;i++){
            Product p = new Product(i,"Product"+i,i*1,i*100.0);
            inventory.add(p);
        }
        inventory.display();
        Product updatedProduct = new Product(1,"Shampoo",4,30.00);
        inventory.update(1, updatedProduct);
        inventory.display();
        inventory.delete(4);
        inventory.display();
    }
}