public class ExcelDocFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();
    }
}