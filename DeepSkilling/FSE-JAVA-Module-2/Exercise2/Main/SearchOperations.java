package Exercise2.Main;



public class SearchOperations {

    public static Product linearSearch(
            Product[] products,
            int targetId) {

        for(Product product : products){

            if(product.getProductId() == targetId){
                return product;
            }

        }

        return null;
    }
    public static Product binarySearch(
            Product[] products,
            int targetId){

        int low = 0;
        int high = products.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(products[mid].getProductId() == targetId){
                return products[mid];
            }

            if(products[mid].getProductId() < targetId){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return null;
    }
}