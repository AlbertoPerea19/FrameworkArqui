package logger.format;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Format extends Formatter{

    @Override
    public String format(LogRecord record) {
        return ":?: -> "
        +"[Date: " + new Date(record.getMillis()) +"] "
        +"[Level: " + record.getLevel() +"] "
        +"[Class: " + record.getLoggerName() + "] "
        +"[Message: " + record.getMessage() + "] "
        +"\n";
    }
    
}