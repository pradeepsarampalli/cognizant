public class Main {
    public static void main(String[] args) {
        DocumentFactory df = new WordFactory();
        Document doc = df.createDocument();
        doc.createfile();
    }
}
