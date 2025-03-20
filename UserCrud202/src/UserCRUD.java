import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
        
        
public class UserCRUD {
    
    private Connection conexion;
    
    public UserCRUD () {
        conexion = ConexionMySQL.conectar();
    }
    
    public boolean crearUsuario(String nom, String cor, String contra){
        
        //secuencia SQL
        String sqlInsert ="INSERT INTO usuarios(nombre,correo,contrasena)VALUE (?,?,?)";
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
    }
}