import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] array = {"FirstWord", "SecondWord", "THIRDWORD", "FourthWord", "FifthWord", "SixthWORD", "SeventhWord", "EighthWord", "NinthWord", "TenthWord"};
        String result = unirElementosArray(array);
        System.out.println(result);
    }

    public static String unirElementosArray(String[] array) {
        if (array.length == 0) {
            return "";
        }

        return Arrays.stream(array)
                .limit(10)
                .map(s -> s.replaceAll("[^a-zA-Z ]", "").toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
