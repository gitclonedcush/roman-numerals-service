package romannumerals;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralController {

    @RequestMapping("/romannumeral")
    public RomanNumeral romanNumeral(@RequestParam(value="query", defaultValue="1") String query) {
        return new RomanNumeral("IV");
    }
}