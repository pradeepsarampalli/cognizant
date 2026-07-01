package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);
    public static void main(String[] args){
        String name = "Umesh";
        int age = 21;
        logger.info("Name : {}",name);
        logger.info("Age :{}",age);
        logger.info("Student : {} age :{}",name,age);
    }
}
