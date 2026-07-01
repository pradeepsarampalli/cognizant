package Exercise3;

public class Sorting {

    public void Bubblesort(Order [] orders){
        int n = orders.length;
        for(int i =0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(orders[j].getTotalPrice() > orders[j+1].getTotalPrice()){
                    Order temp = orders[j];
                    orders[j]=orders[j+1];
                    orders[j+1]=temp;
                }
            }
        }
    }
    public void QuickSort(Order [] orders,int low,int high){
        if(low < high){
            int pivot = partition(orders,low,high);
            QuickSort(orders,low,pivot-1);
            QuickSort(orders,pivot+1,high);
        }
    }
    public int partition(Order [] orders,int low,int high){
        int pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low;j<high;j++){
            if(orders[j].getTotalPrice() < orders[high].getTotalPrice()){
                i++;
                Order temp = orders[j];
                orders[j] = orders[i];
                orders[i] = temp;
            }
        }

        Order temp = orders[high];
        orders[high] = orders[i+1];
        orders[i+1] = temp;

        return  i +1;
    }


}
