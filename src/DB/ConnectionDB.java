package DB;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
 
public class ConnectionDB {
   public Mydb db;
   //public static final String URL = "jdbc:mysql://localhost:3306/pruebajava";

   public ConnectionDB(Mydb db) {
      this.db = db;
   }

   public Connection getConexion(){
      String URL2 = "jdbc:"+db.getSGBD()+"://"+db.getHost()+":"+db.getPort()+"/"+db.getNameDB();
      String CLAVE = db.getPassword();
      String USER = db.getUser();
        Connection con = null;
        try{
            Class.forName(db.getDriver());
            con = (Connection) DriverManager.getConnection(URL2, USER, CLAVE);
            JOptionPane.showMessageDialog(null, "Conexión establecida con éxito");

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            
        }
        return con;
    }

    public void setDb(Mydb db) {
      this.db = db;
    }

    public static void main(String[] args) {

      Mydb db= new Mydb();
      db.setIndex(0);
      db.loadConfiguration();
      ConnectionDB connectionDB= new ConnectionDB(db);
      Connection con= connectionDB.getConexion();
    }

    
}
