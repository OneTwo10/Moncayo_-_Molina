import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Establece la conexión a la base de datos
            connection = DriverManager.getConnection("usuarios.sql");
            
            // Pide al usuario que ingrese su nombre de usuario y contraseña
            System.out.print("Ingrese su nombre de usuario: ");
            String usuario = input.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contrasena = input.nextLine();
            
            // Verifica si el usuario y la contraseña son correctos
            statement = connection.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?");
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // Si los datos de inicio de sesión son correctos, muestra un mensaje de bienvenida
                System.out.println("¡Bienvenido, " + resultSet.getString("nombre") + "!");
            } else {
                // Si los datos de inicio de sesión son incorrectos, muestra un mensaje de error
                System.out.println("Nombre de usuario o contraseña incorrectos.");
            }
        } catch (SQLException e) {
            // Si ocurre un error al conectarse a la base de datos o al consultarla, muestra el mensaje de error correspondiente
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cierra todos los recursos abiertos (result set, statement y connection)
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }
}
