public class Main {
    public static void main(String[] args) {
        new WordFactory().createDocument().open();
        new PdfFactory().createDocument().open();
        new ExcelFactory().createDocument().open();
    }
}