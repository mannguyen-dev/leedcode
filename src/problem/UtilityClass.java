package problem;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilityClass {
    private static final Logger logger = Logger.getLogger(UtilityClass.class.getName());

    private UtilityClass(){}

    public static void logResult(Object data){
        logger.log(Level.INFO, "Result: {0}", data);
    }
}
