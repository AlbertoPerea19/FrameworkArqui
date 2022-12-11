import java.util.logging.Level;
import java.util.logging.Logger;

import logger.MyLogger;

public class Test {
    private static MyLogger myLogger;
    public void testLogger(){
        Logger loggerOf = Logger.getLogger(Test.class.getName());
        myLogger = new MyLogger(loggerOf);
  
        for(int i = 0; i < 6 ; i++){
            myLogger.writeMessage(Level.INFO, "Mensaje # " + i);
        
        }
    }
}
