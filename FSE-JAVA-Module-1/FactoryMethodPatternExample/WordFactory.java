public class WordFactory extends DocumentFactory{
    WordFactory(){
        System.out.println("WordFactory is created ");
    }
    Document createDocument(){
        return new PdfDocument();
    }
}
