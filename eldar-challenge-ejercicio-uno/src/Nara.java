import java.math.BigDecimal;
import java.time.LocalDate;

public class Nara extends Tarjeta {
    public Nara(String marca, String numero, CardHolder caldholder, LocalDate fechaVencimiento) {
        super(marca, numero, caldholder, fechaVencimiento);
    }

    public Nara() {
    }
    @Override
    public BigDecimal calcularTasa() throws CalculoTasaException {
        try {
            int dia = this.getFechaVencimiento().getDayOfMonth();

            double tasa = (double) dia * 0.5;
            return BigDecimal.valueOf(tasa).setScale(2, BigDecimal.ROUND_HALF_UP);
        } catch (NullPointerException e) {
            throw new CalculoTasaException("Error al calcular la tasa.", e);
        }
    }

}
