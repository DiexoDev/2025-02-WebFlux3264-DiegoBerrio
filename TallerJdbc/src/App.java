
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class App {
    private static final String url = "jdbc:mysql://localhost:3306/tallerjdbc";
    private static final String user = "root";
    private static final String password = "root";

    public static void main(String[] args) throws Exception {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            EstudianteServicio estudianteServicio = new EstudianteServicio();

            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Que desea realizar?"
                    + "\n1. Insertar estudiante"
                    + "\n2. Actualizar estudiante"
                    + "\n3. Eliminar estudiante"
                    + "\n4. Consultar todos los estudiantes"
                    + "\n5. Consultar estudiante por email"
                    + "\n6. Salir"
                    + "\nRespuesta: ");

            byte opcion = scanner.nextByte();
            switch (opcion) {
                case 1 -> estudianteServicio.insertarEstudiante(connection);
                case 2 -> estudianteServicio.actualizarEstudiante(connection);
                case 3 -> estudianteServicio.eliminarEstudiante(connection);
                case 4 -> estudianteServicio.consultarEstudiantes(connection);
                case 5 -> estudianteServicio.consultarEstudiantePorEmail(connection);
                case 6 -> System.out.println("Saliendo...");
            }

            scanner.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
