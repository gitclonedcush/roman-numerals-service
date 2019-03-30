package romannumerals;

import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralTests {

    @Test
    @Parameters({
        "1, I",
        "5, V", 
        "7, VII", 
        "10, X", 
        "12, XII", 
        "50, L",
        "55, LV", 
        "100, C", 
        "101, CI", 
        "400, CD", 
        "500, D",
        "555, DLV",
        "3000, MMM",
        "3004, MMMIV"
    })
    public void TestCreateRomanNumeral(int numeral, String expectedRomanNumeral) {
        RomanNumeral rN = new RomanNumeral(numeral);
        assertEquals(expectedRomanNumeral, rN.toString());
    }

    @Test
    @Parameters({
        "-100",
        "-9", 
        "-1", 
        "0", 
    })
    public void TestInvalidRomanNumeral(int numeral) {
        RomanNumeral rN = new RomanNumeral(numeral);
        assertEquals("", rN.toString());
    }
}