public class BubbleSort {
    public static void sort(Order[] orders){
        for(int i=0;i<orders.length-1;i++){
            for(int j=0;j<orders.length-i-1;j++){
                if(orders[j].getTotalPrice()>orders[j+1].getTotalPrice()){
                    Order temp=orders[j];
                    orders[j]=orders[j+1];
                    orders[j+1]=temp;
                }
            }
        }
    }
}