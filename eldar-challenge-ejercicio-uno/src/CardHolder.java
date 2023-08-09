public class CardHolder {
    private String nombre;
    private String apellido;

    private String denominacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDenominacion() {
        return nombre + " " + apellido;
    }

    public CardHolder(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public CardHolder() {
    }
}
