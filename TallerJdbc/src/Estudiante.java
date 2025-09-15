public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int edad;
    private EstadoCivil estadoCivil;

    public Estudiante() {
    }

    public Estudiante(String apellido, String correo, int edad, EstadoCivil estadoCivil, int id, String nombre) {
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", correo=").append(correo);
        sb.append(", edad=").append(edad);
        sb.append(", estadoCivil=").append(estadoCivil);
        sb.append('}');
        return sb.toString();
    }

}
