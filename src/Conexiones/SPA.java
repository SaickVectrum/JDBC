
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


  public class SPA {
    String bd ="spa";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    Statement statement;
    ResultSet rs;
    
    public SPA(){
        
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd, user, password);
            System.out.println("Se conecto a la Base de Datos "+bd);
            statement = cx.createStatement();
            statement.executeUpdate("INSERT INTO CLIENTE(NOMBRE_CLIENTE,TELEFONO_CLIENTE,CORREO_ELEC_CLIENTE,CONTRASEÑA_CLIENTE) VALUES('Manuel Rodrigguezzz','31254789775','manRoodrii275@email.com','manu1234567')");
            rs= statement.executeQuery("SELECT * FROM CLIENTE");
            rs.next();
            do{
                System.out.println(rs.getString("nombre_cliente")+" : "+rs.getString("telefono_cliente")+" : "+rs.getString("correo_elec_cliente")+" : "+rs.getString("contraseña_cliente"));
            }while(rs.next());
            
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("No se conecto a la Base de Datos "+bd);
                        Logger.getLogger(SPA.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return cx;
    }
    
    
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(SPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        SPA conexion=new SPA();
        conexion.conectar();
        
    }
}  

