package romannumerals;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralController {

    /**
     * RomanNumeralController 
     * Given an input number returns the corresponding roman numeral.
     * For example:
     *      /romannumeral?query=6
     *      {
     *          numeral: 6
     *          romanNumeral: VI
     *      }
     *
     * @param  query input to convert to roman numeral 
     * @return       json body that contains original number and roman numeral conversion. 
     */
    @RequestMapping("/romannumeral")
    public RomanNumeral romanNumeral(@RequestParam(value="query", defaultValue="1") Integer query) {
        return new RomanNumeral(query);
    }
}