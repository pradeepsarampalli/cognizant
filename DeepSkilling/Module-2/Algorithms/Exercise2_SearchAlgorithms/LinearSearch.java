public class LinearSearch {
    public static Product search(Product[] products,String key){
        for(Product p:products){
            if(p.getProductName().equalsIgnoreCase(key))
                return p;
        }
        return null;
    }
}