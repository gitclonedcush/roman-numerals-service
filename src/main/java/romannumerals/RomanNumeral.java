package romannumerals;

import java.util.NavigableMap;
import java.util.TreeMap;

public class RomanNumeral{

    private final Integer numeral;
    private final String romanNumeral;

    private static NavigableMap<Integer, String> romanNumerals = new TreeMap<Integer, String>();

    static {
        romanNumerals.put(1, "I");
        romanNumerals.put(4, "IV");
        romanNumerals.put(5, "V");
        romanNumerals.put(9, "IX");
        romanNumerals.put(10, "X");
        romanNumerals.put(40, "XL");
        romanNumerals.put(50, "L");
        romanNumerals.put(90, "XC");
        romanNumerals.put(100, "C");
        romanNumerals.put(400, "CD");
        romanNumerals.put(500, "D");
        romanNumerals.put(900, "CM");
        romanNumerals.put(1000, "M");
    }

    public RomanNumeral(int number) {
        this.numeral = number;
        this.romanNumeral = convert(number);
    }

    public String toString() {
        return this.romanNumeral;
    }

    public int getNumeral() {
        return this.numeral;
    }

    public String getRomanNumeral() {
        return this.romanNumeral;
    }

    private String convert(int number)
    {
        if (number <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            int floored  = romanNumerals.floorKey(number);
            String numeral = romanNumerals.get(floored);

            sb.append(numeral);

            number -= floored;
        }

        return sb.toString();
    }
}