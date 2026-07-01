package Singleton;

public class Logger{
    static private Logger logger;
    private Logger(){
    }
    public void print(){
        System.out.println("Singleten pattern");
    }
    public static Logger getLogger(){
        if(logger == null){
            logger = new Logger();
            return logger;
        }
        return logger;
    }
}