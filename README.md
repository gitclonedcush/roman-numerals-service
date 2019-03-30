# roman-numerals-service
A java web service to convert integers to roman numeral strings

## Usage 
For example `GET http://localhost:8080/romannumeral?query=12` would return the roman numeral string `XII`

## Dependencies

Gradle:
```
------------------------------------------------------------
Gradle 5.3
------------------------------------------------------------

Build time:   2019-03-20 11:03:29 UTC
Revision:     f5c64796748a98efdbf6f99f44b6afe08492c2a0

...
JVM:          11.0.2 (Oracle Corporation 11.0.2+9-LTS)
```

## Testing
* Run tests with `gradle test`
* The tests are configured to show their status in console output.

## Spec
[Roman Numeral Spec](http://mathworld.wolfram.com/RomanNumerals.html)

A number can be converted to a roman numeral with the following algorithm:
* If number is 0 return
* Repeat:
    * Lookup highest key that is less than number in roman numeral map
    * Append the corresponding value to roman numeral string
    * number = number - key
