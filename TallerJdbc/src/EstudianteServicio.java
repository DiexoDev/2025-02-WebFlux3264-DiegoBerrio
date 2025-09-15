
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EstudianteServicio {

    private Scanner scanner;

    public void insertarEstudiante(Connection connection) throws SQLException {
        scanner = new Scanner(System.in);
        Estudiante estudiante = new Estudiante();

        System.out.println("\tInsertar nuevo estudiante"
                + "\nIngrese el nombre:");
        String nombre = scanner.nextLine();
        estudiante.setNombre(nombre);

        System.out.println("Ingrese el apellido:");
        String apellido = scanner.nextLine();
        estudiante.setApellido(apellido);

        System.out.println("Ingrese su correo:");
        String correo = scanner.nextLine();
        estudiante.setCorreo(correo);

        System.out.println("Ingrese su edad:");
        byte edad = scanner.nextByte();
        estudiante.setEdad(edad);

        System.out.println("Seleccione su estado civil:"
                + "\n1. Soltero"
                + "\n2. Casado"
                + "\n3. Divorciado"
                + "\n4. Viudo"
                + "\nRespuesta: ");
        byte opcion = scanner.nextByte();

        switch (opcion) {
            case 1 -> estudiante.setEstadoCivil(EstadoCivil.SOLTERO);
            case 2 -> estudiante.setEstadoCivil(EstadoCivil.CASADO);
            case 3 -> estudiante.setEstadoCivil(EstadoCivil.DIVORCIADO);
            case 4 -> estudiante.setEstadoCivil(EstadoCivil.VIUDO);
        }

        String query = "INSERT INTO Estudiante(nombre, apellido, correo, edad, estadoCivil) VALUES (?,?,?,?,?)";
        var preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, apellido);
        preparedStatement.setString(3, correo);
        preparedStatement.setByte(4, edad);
        preparedStatement.setString(5, estudiante.getEstadoCivil().toString());

        int filasModificadas = preparedStatement.executeUpdate();
        if (filasModificadas > 0) {
            System.out.println("Estudiante registrado con exito! \n" + estudiante);
        } else {
            System.out.println("No se pudo registrar el estudiante");
        }

        scanner.close();

    }

    public void actualizarEstudiante(Connection connection) throws SQLException {
        scanner = new Scanner(System.in);
        Estudiante estudiante = new Estudiante();

        System.out.println("Ingrese el ID del estudiante a actualizar:");
        byte id = scanner.nextByte();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre:");
        String nombre = scanner.nextLine();
        estudiante.setNombre(nombre);

        System.out.println("Ingrese el nuevo apellido:");
        String apellido = scanner.nextLine();
        estudiante.setApellido(apellido);

        System.out.println("Ingrese la nueva edad:");
        byte edad = scanner.nextByte();
        estudiante.setEdad(edad);

        System.out.println("Seleccione el nuevo estado civil:"
                + "\n1. Soltero"
                + "\n2. Casado"
                + "\n3. Divorciado"
                + "\n4. Viudo"
                + "\nRespuesta: ");
        byte opcion = scanner.nextByte();

        switch (opcion) {
            case 1 -> estudiante.setEstadoCivil(EstadoCivil.SOLTERO);
            case 2 -> estudiante.setEstadoCivil(EstadoCivil.CASADO);
            case 3 -> estudiante.setEstadoCivil(EstadoCivil.DIVORCIADO);
            case 4 -> estudiante.setEstadoCivil(EstadoCivil.VIUDO);
        }

        String query = "UPDATE Estudiante SET nombre=?, apellido=?, edad=?, estadoCivil=? WHERE id=?";
        var preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, apellido);
        preparedStatement.setInt(3, edad);
        preparedStatement.setString(4, estudiante.getEstadoCivil().toString());
        preparedStatement.setInt(5, id);

        int filasModificadas = preparedStatement.executeUpdate();
        if (filasModificadas > 0) {
            System.out.println("Estudiante actualizado con exito! \n" + estudiante);
        } else {
            System.out.println("No se pudo actualizar el estudiante");
        }

        scanner.close();

    }

    public void eliminarEstudiante(Connection connection) throws SQLException {
        scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del estudiante a eliminar:");
        byte id = scanner.nextByte();

        String query = "DELETE FROM Estudiante WHERE id = ?";
        var preparedStatement = connection.prepareStatement(query);
        preparedStatement.setObject(1, id);
        int filasModificadas = preparedStatement.executeUpdate();
        if (filasModificadas > 0) {
            System.out.println("Estudiante eliminado con exito!");
        } else {
            System.out.println("No se pudo eliminar el estudiante");
        }
    }

    public void consultarEstudiantes(Connection connection) throws SQLException {
        String query = "SELECT * FROM Estudiante";
        var preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String correo = resultSet.getString("correo");
            byte edad = resultSet.getByte("edad");
            String estadoCivil = resultSet.getString("estadoCivil");
            System.out.println(String.format("ID: %d, Nombre: %s, Apellido: %s, Correo: %s, Edad: %d, Estado Civil: %s",
                    id, nombre, apellido, correo, edad, estadoCivil));
        }

    }

    public void consultarEstudiantePorEmail(Connection connection) throws SQLException {
        scanner = new Scanner(System.in);
        System.out.println("Ingrese el correo del estudiante a buscar:");
        String correoBuscado = scanner.nextLine();

        String query = "SELECT * FROM Estudiante WHERE correo=?";
        var preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, correoBuscado);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String correo = resultSet.getString("correo");
            byte edad = resultSet.getByte("edad");
            String estadoCivil = resultSet.getString("estadoCivil");
            System.out.println(String.format("ID: %d, Nombre: %s, Apellido: %s, Correo: %s, Edad: %d, Estado Civil: %s",
                    id, nombre, apellido, correo, edad, estadoCivil));
        }

    }
}
