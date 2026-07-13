public class Main {
    public static void main(String[] args){

        Book[] books = {
            new Book(101,"Java Programming","James"),
            new Book(102,"Data Structures","Mark"),
            new Book(103,"Algorithms","Robert"),
            new Book(104,"Operating Systems","Andrew")
        };

        System.out.println("Linear Search:");
        System.out.println(LibrarySearch.linearSearch(books,"Algorithms"));

        LibrarySearch.sort(books);

        System.out.println("\nBinary Search:");
        System.out.println(LibrarySearch.binarySearch(books,"Algorithms"));
    }
}