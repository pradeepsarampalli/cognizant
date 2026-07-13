public class Product {
    int productId;
    String productName;
    int quantity;
    double price;
    public Product(){}
    public Product(int id,String name,int quantity,double price){
        this.productId=id;
        this.productName=name;
        this.quantity=quantity;
        this.price=price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String toString() {
        return "[ id :" + productId +", Name : "+ productName +", Quantity: "+quantity+", Price: "+price +" ]";
    }
}
