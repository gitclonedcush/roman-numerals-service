package romannumerals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RomanNumeralIntegrationTests {

	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void TestGetRomanNumeral() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romannumeral?query=12"),
				HttpMethod.GET, entity, String.class);

		String expected = "{numeral:12, romanNumeral:XII}";

		// disable strict checking so we don't have to worry about escaping strings
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void TestGetInvalidRomanNumeral() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romannumeral?query=0"),
				HttpMethod.GET, entity, String.class);

		String expected = "{\"numeral\":0,\"romanNumeral\":\"\"}";
		String actual = response.getBody();

		// Enable strict checking so we ne know we actually get an empty string
		JSONAssert.assertEquals(expected, actual, true);
	}

	@Test
	public void TestDefaultRomanNumeral() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romannumeral"),
				HttpMethod.GET, entity, String.class);

		// roman numeral defaults to I if no query param is provided.
		String expected = "{numeral: 1, romanNumeral: I}";
		String actual = response.getBody();

		JSONAssert.assertEquals(expected, actual, false);
	}
}
