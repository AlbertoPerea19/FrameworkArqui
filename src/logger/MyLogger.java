package logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import InterfaceReader.setConfigJSON;
import configReader.ValidarLectura;
import logger.filtro.Filtro;
import logger.format.Format;
import logger.handler.MyHandler;


public class MyLogger implements setConfigJSON{
    private final Logger logger;
    private String pattern;
    private int limit;
    private int count;
    private JSONObject configLog;

    public MyLogger(Logger loggerOf){
        this.logger = loggerOf;
        this.readConfiguration();
        this.loadConfiguration();
        this.setUpLogger();
    }

    public MyLogger(Logger loggerOf, MyHandler handler, Format format, Filtro filtro){
        this.logger = loggerOf;
        this.readConfiguration();
        this.loadConfiguration();
        this.setUpLogger(handler,format,filtro);
    }

    @Override
    public void readConfiguration(){
        try{
            String configPath = "src/Settings.txt";
            ValidarLectura validacionJSON = new ValidarLectura();
            JSONObject configObject = validacionJSON.extractJSONObject(validacionJSON.readJSON(configPath));
            JSONArray logArray = validacionJSON.extractJSONArray(configObject, "log");
            JSONObject configLogObject = (JSONObject) logArray.get(0);
        this.configLog = configLogObject;
        }catch(Exception e){

        }
    }
    @Override
    public void loadConfiguration(){
        try{
            String configPath = "src/Settings.txt";
            LogManager logManager = LogManager.getLogManager();
            FileInputStream fileInputStream = new FileInputStream(configPath);
            logManager.readConfiguration(fileInputStream);
            setCount(Integer.parseInt((String) configLog.get("maxLogFiles")));
            setLimit(Integer.parseInt((String) configLog.get("limit")));
            setPattern(configLog.get("pattern").toString());
        }catch(SecurityException | IOException | NumberFormatException e){
            e.printStackTrace();
        }
    }

    private void setUpLogger(MyHandler handler, Format format, Filtro filtro){
        this.logger.addHandler(handler);
        Handler myHandler = null;
        try {
            myHandler = new FileHandler(getPattern(), getLimit(), getCount());
            myHandler.setFormatter(format);
            myHandler.setFilter(filtro);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.logger.addHandler(myHandler);
    }

    private void setUpLogger(){
        this.logger.addHandler(new MyHandler());
        Handler myHandler = null;
        try {
            myHandler = new FileHandler(getPattern(), getLimit(), getCount());
            myHandler.setFormatter(new Format());
            myHandler.setFilter(new Filtro());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.logger.addHandler(myHandler);
    }

    public void writeMessage(Level level, String mensaje){
        this.logger.log(level, mensaje);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}