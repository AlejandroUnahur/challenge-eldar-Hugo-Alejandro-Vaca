import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws CalculoTasaException {
        //CardHolders
        CardHolder cardHolder1 = new CardHolder("Juan","Perez");
        CardHolder cardHolder2 = new CardHolder("Peter", "Parker");
        CardHolder cardHolder3 = new CardHolder("Anakin", "Skywalker");

        //Tarjetas
        Visa visa = new Visa("VISA","5246951615795181",cardHolder1,LocalDate.of(2027, 4, 4));
        Nara nara = new Nara("NARA","5246951615795182",cardHolder2,LocalDate.of(2027, 5,27));
        Amex amex = new Amex("AMEX","5246951615795183",cardHolder3,LocalDate.of(2025,9, 3));

        //Obtener datos de la tarjeta
        System.out.println("\n" + visa.obtenerInformacionTarjeta());
        System.out.println("\n" + nara.obtenerInformacionTarjeta());
        System.out.println("\n" + amex.obtenerInformacionTarjeta());

        //Es una operacion válida
        System.out.println("\nEs una operacion valida: " + visa.esOperacionValida(900.0));

        //Es una tarjeta válida para operar
        System.out.println("\nEs una tarjeta válida para operar: " + visa.puedeOperar());

        //Identificar si una tarjeta es distinta de otra
        System.out.println("\nEs una tarjeta válida para operar: " + visa.esTarjetaDistinta(nara));

        //Calcular tasa
        System.out.println("\nTasa tarjeta Visa: " + visa.calcularTasa());

        System.out.println("\nTasa tarjeta Nara: " + nara.calcularTasa());

        System.out.println("\nTasa tarjeta Amex: " + amex.calcularTasa());
    }
}