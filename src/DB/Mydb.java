package DB;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import InterfaceReader.setConfigJSON;
import configReader.ValidarLectura;

public class Mydb  implements setConfigJSON{

   private String SGBD;
   private String nameDB;
   private String host;
   private String port;
   private String user;
   private String password;
   private JSONObject configDB;
   private String driver;
   private int index;
   private JSONArray logArray;


   public Mydb() {
      readConfiguration();
   }

   @Override
   public void readConfiguration(){
      String configPath = "ProyectoArquitectura/EntregableFramework/src/Settings.txt";
      ValidarLectura validacionJSON = new ValidarLectura();
      JSONObject configObject = validacionJSON.extractJSONObject(validacionJSON.readJSON(configPath));
      logArray = validacionJSON.extractJSONArray(configObject, "databaseAccess");
  }

   @Override
   public void loadConfiguration() {
      try{
         //String configPath = "ProyectoArquitectura/EntregableFramework/src/Settings.txt";
         setSGBD((String)configDB.get("databaseId"));
         setHost((String)configDB.get("host"));
         setNameDB((String)configDB.get("databaseName"));
         setPassword((String)configDB.get("password"));
         setUser((String)configDB.get("user"));
         setPort((String)configDB.get("port"));
         setDriver((String)configDB.get("driver"));
     }catch(SecurityException | NumberFormatException e){
         e.printStackTrace();
     }
   }

   
   public void setIndex(int index) {
      JSONObject configDBObject = (JSONObject) logArray.get(index);
      this.configDB = configDBObject;
   }

   public String getDriver() {
      return driver;
   }

   public void setDriver(String driver) {
      this.driver = driver;
   }

   public String getSGBD() {
      return SGBD;
   }

   public void setSGBD(String sGBD) {
      SGBD = sGBD;
   }

   public String getHost() {
      return host;
   }

   public void setHost(String host) {
      this.host = host;
   }

   public String getNameDB() {
      return nameDB;
   }

   public void setNameDB(String nameDB) {
      this.nameDB = nameDB;
   }

   public String getPort() {
      return port;
   }

   public void setPort(String port) {
      this.port = port;
   }

   public JSONObject getConfigDB() {
      return configDB;
   }

   public void setConfigDB(JSONObject configDB) {
      this.configDB = configDB;
   }

   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   
}
