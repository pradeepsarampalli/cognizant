import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    public static Book linearSearch(Book[] books, String title){
        for(Book b : books){
            if(b.getTitle().equalsIgnoreCase(title))
                return b;
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title){
        int low = 0, high = books.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if(cmp == 0)
                return books[mid];
            else if(cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void sort(Book[] books){
        Arrays.sort(books, Comparator.comparing(Book::getTitle));
    }
}