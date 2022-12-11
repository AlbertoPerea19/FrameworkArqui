import java.util.logging.Logger;
import logger.MyLogger;


import test.TestMVC;

public class App {
    private static MyLogger myLogger;
    public static void main(String[] args) throws Exception {
        TestMVC tMVC = new TestMVC();
        tMVC.testMVC();
    }
}
