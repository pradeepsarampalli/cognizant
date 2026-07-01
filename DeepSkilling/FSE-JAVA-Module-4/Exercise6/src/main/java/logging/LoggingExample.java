package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoggingExample.class);
    public static void main(String[] args){
        logger.error("This is the error message");
        logger.warn("This is Warning Message");
    }
}
