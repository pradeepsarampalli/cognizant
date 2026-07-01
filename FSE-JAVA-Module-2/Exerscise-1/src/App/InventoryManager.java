package App;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product){
        inventory.put(product.getProductId(), product);
    }

    // Update Product
    public void updateProduct(Product product){
        if(inventory.containsKey(product.getProductId())){
            inventory.put(product.getProductId(), product);
        }
        else{
            System.out.println("Product not found");
        }
    }

    // Delete Product
    public void deleteProduct(int productId){
        if(inventory.containsKey(productId)){
            inventory.remove(productId);
        }
        else{
            System.out.println("Product not found");
        }
    }

    // Display Products
    public void displayProducts(){
        for(Product product : inventory.values()){
            System.out.println(product);
        }
    }
}