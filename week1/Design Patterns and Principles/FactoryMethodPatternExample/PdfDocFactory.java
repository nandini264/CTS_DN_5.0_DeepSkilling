public class PdfDocFactory extends DocumentFactory{
    public Document createDocument(){
        return new PdfDocument();
    }
}