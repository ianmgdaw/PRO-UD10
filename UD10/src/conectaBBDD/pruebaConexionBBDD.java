/*
 * Proyecto UD10 - Archivo pruebaConexionBBDD.java - Compañia DAW
 * Licencia Creative Commons BY-NC-SA 4.0
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 */

package conectaBBDD;

/**
 *
 * @author Ian Molina Guillo <ianmg.daw@gmail.com>
 * @version 1.0
 * @date 30 mar. 2022 19:30:54
 */
public class pruebaConexionBBDD {
    public static void main(String[] args) {
     
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC");
        }
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/prueba";
            String username = "netbeans";
            String password = "netbeans2022";
            
            Connection connection = DriverManager.getConnection(url, username, password);
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persona");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                Date fecha = rs.getDate("fecha");
                
                System.out.println(String.format("%d, %s %s, %s", id, nombre, apellido, fecha));
            }
            
            rs.close();
            statement.close();
            connection.close();
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
    }
    
}
