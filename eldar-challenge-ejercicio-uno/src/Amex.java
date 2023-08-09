import java.math.BigDecimal;
import java.time.LocalDate;

public class Amex extends Tarjeta {
    @Override
    public BigDecimal calcularTasa() throws CalculoTasaException {
        try {
            int mes = this.getFechaVencimiento().getMonthValue();
            double tasa = (double) mes * 0.1;
            return BigDecimal.valueOf(tasa).setScale(2, BigDecimal.ROUND_HALF_UP);
        } catch (NullPointerException e) {
            throw new CalculoTasaException("Error al calcular la tasa.", e);
        }
    }

    public Amex(String marca, String numero, CardHolder caldholder, LocalDate fechaVencimiento) {
        super(marca, numero, caldholder, fechaVencimiento);
    }

    public Amex() {
    }
}
