package Exercise3;



public class Main {

    public static void main(String[] args) {

        Order[] orders = {
                new Order(101, "Umesh", 5000),
                new Order(102, "Rahul", 2000),
                new Order(103, "Priya", 8000),
                new Order(104, "Kiran", 1000)
        };


        Sorting s = new Sorting();

        s.QuickSort(orders, 0, orders.length - 1);

        for (Order order : orders) {
            System.out.println(order);
        }
        Sorting sorting = new Sorting();

        s.Bubblesort(orders);

        for (Order order : orders) {
            System.out.println(order);
        }
    }
}