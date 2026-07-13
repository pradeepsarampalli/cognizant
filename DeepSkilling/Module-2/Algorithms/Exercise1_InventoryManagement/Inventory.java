import java.util.HashMap;

public class Inventory {
    HashMap<Integer,Product> products;
    public Inventory(){
        this.products = new HashMap<>();
    }

    //0(1)
    public boolean add(Product p){
        products.put(p.getProductId(),p);
        return true;
    }

    //0(1)
    public boolean update(int id,Product p){
        if(products.containsKey(id)){
            products.put(id,p);
            return true;
        }
        return false;
    }

    //0(1)
    public boolean delete(int id){
        if(products.containsKey(id)){
            products.remove(id);
            return false;
        }
        return true;
    }


    public void display(){
        for(int key:products.keySet()){
            System.out.println(products.get(key));
        }
    }
}
