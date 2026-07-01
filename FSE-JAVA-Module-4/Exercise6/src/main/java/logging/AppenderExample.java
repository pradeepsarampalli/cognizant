package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger =
            LoggerFactory.getLogger(AppenderExample.class);
    public static void main(String[] args){
        logger.info("Application Started");
        logger.warn("Low Memory");
        logger.error("Database Connection Failed");
    }
}
