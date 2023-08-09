import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Tarjeta {

    private String marca;
    private String numero;
    private CardHolder caldholder;
    private LocalDate fechaVencimiento;
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public CardHolder getCaldholder() {
        return caldholder;
    }

    public void setCaldholder(CardHolder caldholder) {
        this.caldholder = caldholder;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "marca='" + marca + '\'' +
                ", numero='" + numero + '\'' +
                ", caldholder=" + caldholder +
                ", fechaVencimiento=" + fechaVencimiento +
                '}';
    }

    public String obtenerInformacionTarjeta() {
        return "Marca: " + marca +
                "\nNúmero: " + numero +
                "\nTitular: " + caldholder.getDenominacion() +
                "\nFecha de Vencimiento: " + fechaVencimiento;
    }

    public Tarjeta() {
    }

    public Tarjeta(String marca, String numero, CardHolder caldholder, LocalDate fechaVencimiento) {
        this.marca = marca;
        this.numero = numero;
        this.caldholder = caldholder;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return Objects.equals(marca, tarjeta.marca) && Objects.equals(numero, tarjeta.numero) && Objects.equals(caldholder, tarjeta.caldholder) && Objects.equals(fechaVencimiento, tarjeta.fechaVencimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, numero, caldholder, fechaVencimiento);
    }

    public boolean esOperacionValida(Double consumo) {
        return consumo < 1000;
    }
    public boolean puedeOperar() {
        return this.fechaVencimiento.isAfter(LocalDate.now());
    }
    abstract public BigDecimal calcularTasa() throws CalculoTasaException;

    public boolean esTarjetaDistinta(Tarjeta tarjeta) {
        return !this.getNumero().equals(tarjeta.getNumero());
    }

}
