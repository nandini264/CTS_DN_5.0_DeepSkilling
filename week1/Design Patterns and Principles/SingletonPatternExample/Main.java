
public class Main{
    public static void main(String[] args){
        Logger log1=Logger.getInstance();
        System.out.println("First Logger");
        Logger log2=Logger.getInstance();
        System.out.println("Second Logger");

        if(log1==log2)
            System.out.println("Same instance of logger is created- SingletonPattern Implemented Successfully");
        else
            System.out.println("Different instances created- SingletonPattern Implementation Failed");

        
    }
}