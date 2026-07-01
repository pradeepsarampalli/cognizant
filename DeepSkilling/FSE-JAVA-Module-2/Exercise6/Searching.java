package Exercise6;

public class Searching {

    private Book[] books;
    private int count;

    public Searching(int n) {
        books = new Book[n];
        count = 0;
    }

    public void add(Book book) {

        if(count == books.length) {
            System.out.println("Library Full");
            return;
        }

        books[count++] = book;
    }

    public Book linearSearch(String title) {

        for(int i = 0; i < count; i++) {

            if(books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }

    public Book binarySearch(String title) {

        int low = 0;
        int high = count - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            int compare =
                    books[mid].getTitle().compareToIgnoreCase(title);

            if(compare == 0) {
                return books[mid];
            }
            else if(compare < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public void traverse() {

        for(int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}
