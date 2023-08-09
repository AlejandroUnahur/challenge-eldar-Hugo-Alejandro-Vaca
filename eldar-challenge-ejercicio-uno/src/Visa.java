import java.math.BigDecimal;
import java.time.LocalDate;

public class Visa extends Tarjeta {
    public Visa(String marca, String numero, CardHolder caldholder, LocalDate fechaVencimiento) {
        super(marca, numero, caldholder, fechaVencimiento);
    }

    public Visa() {
    }

    @Override
    public BigDecimal calcularTasa() throws CalculoTasaException {
        int anio = this.getFechaVencimiento().getYear() % 100;
        int mes = this.getFechaVencimiento().getMonthValue();

        if(mes == 0 ) {
            throw new IllegalArgumentException("El mes no puede ser cero.");
        }

        double tasa = (double) anio / mes;

        try {
            tasa = (double) anio / mes;
        } catch (ArithmeticException | NullPointerException e) {
            throw new CalculoTasaException("Error al calcular la tasa.", e);
        }

        return BigDecimal.valueOf(tasa).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
