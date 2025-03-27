import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
        
        
public class UserCRUD {
    
    private Connection conexion;
    
    public UserCRUD () {
        conexion = ConexionMySQL.conectar();
    }
    
    public boolean crearUsuario(String nom, String cor, String contra){
        
        //secuencia SQL
        String sqlInsert ="INSERT INTO Usuarios(nombre,correo,contrasena)VALUE (?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sqlInsert);
            ps.setString(1, nom);
            ps.setString(2, cor);
            ps.setString(3, contra);
            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
        System.out.println("Error al intentar insertar" + e.getMessage());
        return false;
               
        }
    }//fin del insert
    
    public ResultSet obtenerUsuarioPorID (int id){
        String selectSql = "SELECT * FROM Usuarios WHERE id = ?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(selectSql);
            ps.setInt(1, id);
            return ps.executeQuery();
        }//llave try
        
       catch(SQLException e){
            System.out.println("Error al intentar COnsultar: "+ e.getMessage());
            return null;
        }//llave catch
    }//lave obtenerUsuarioPorID
    
    public ResultSet obtenerTodos (){
        String sqlTodos = "SELECT * FROM Usuarios";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sqlTodos);
            return ps.executeQuery();
        }
        catch(SQLException w){
            System.out.println("Error al cosultar"+w.getMessage());
            return null;
        }
    }
    
    
    
    
}