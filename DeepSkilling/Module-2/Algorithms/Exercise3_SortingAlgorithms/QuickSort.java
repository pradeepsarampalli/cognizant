public class QuickSort {
    public static void sort(Order[] arr,int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }
    }

    private static int partition(Order[] arr,int low,int high){
        double pivot=arr[high].getTotalPrice();
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j].getTotalPrice()<=pivot){
                i++;
                Order t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        Order t=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=t;
        return i+1;
    }
}