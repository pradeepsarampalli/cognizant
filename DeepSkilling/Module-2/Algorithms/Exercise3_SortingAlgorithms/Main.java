public class Main{
    public static void main(String[] args){
        Order[] orders={
            new Order(1,"Alice",1200),
            new Order(2,"Bob",450),
            new Order(3,"Charlie",3000),
            new Order(4,"David",800)
        };

        System.out.println("Bubble Sort:");
        BubbleSort.sort(orders);
        for(Order o:orders) System.out.println(o);
        Order[] orders2={
            new Order(1,"Alice",1200),
            new Order(2,"Bob",450),
            new Order(3,"Charlie",3000),
            new Order(4,"David",800)
        };
        System.out.println("\nQuick Sort:");
        QuickSort.sort(orders2,0,orders2.length-1);
        for(Order o:orders2) System.out.println(o);
    }
}