package assignment6.solutions.delegation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistributingLoggerTest {

	private static final String formatString = "%s: %s (%s)";

	private ByteArrayOutputStream infoStream;
	private ByteArrayOutputStream warnStream;
	private ByteArrayOutputStream errorStream;
	private DistributingLogger logger;
	private StreamLogger infoLogger;
	private StreamLogger warnLogger;
	private StreamLogger errorLogger;

	@BeforeEach
	public void setUp() {
		infoStream = new ByteArrayOutputStream();
		warnStream = new ByteArrayOutputStream();
		errorStream = new ByteArrayOutputStream();

		infoLogger = new StreamLogger(infoStream);
		warnLogger = new StreamLogger(warnStream);
		errorLogger = new StreamLogger(errorStream);

		logger = new DistributingLogger(errorLogger, warnLogger, infoLogger);
	}

	@Test
	@DisplayName("Logge til INFO")
	public void testLogToInfo() {
		infoLogger.setFormatString(formatString);
		logger.log(ILogger.INFO, "Dette er en info-melding.", null);
		assertEquals(String.format(formatString, ILogger.INFO, "Dette er en info-melding.", null),
				infoStream.toString().trim(), "Teste formatet på info-meldingen etter logging");
		assertEquals("", warnStream.toString(),
				"Teste warning-strømmen etter å ha logget en info-melding");
		assertEquals("", errorStream.toString(),
				"Teste error-strømmen etter å ha logget en info-melding");
	}

	@Test
	@DisplayName("Logge til WARNING")
	public void testLogToWarn() {
		warnLogger.setFormatString(formatString);
		logger.log(ILogger.WARNING, "Dette er en advarsel.", null);
		assertEquals(String.format(formatString, ILogger.WARNING, "Dette er en advarsel.", null),
				warnStream.toString().trim(), "Teste formatet på warning-meldingen etter logging");
		assertEquals("", infoStream.toString(),
				"Teste info-strømmen etter å ha logget en info-melding");
		assertEquals("", errorStream.toString(),
				"Teste error-strømmen etter å ha logget en info-melding");
	}

	@Test
	@DisplayName("Logge til ERROR")
	public void testLogToError() {
		Exception exception = new IllegalStateException();
		errorLogger.setFormatString(formatString);
		logger.log(ILogger.ERROR, "Dette er en feilmelding.", exception);
		assertEquals(
				String.format(formatString, ILogger.ERROR, "Dette er en feilmelding.", exception),
				errorStream.toString().trim(), "Teste formatet på error-meldingen etter logging");
		assertEquals("", warnStream.toString(),
				"Teste warning-strømmen etter å ha logget en error-melding");
		assertEquals("", infoStream.toString(),
				"Teste info-strømmen etter å ha logget en error-melding");
	}

	@Test
	@DisplayName("Endre info-logger")
	public void testChangeInfoLogger() {
		ByteArrayOutputStream newInfoStream = new ByteArrayOutputStream();
		StreamLogger newInfoLogger = new StreamLogger(newInfoStream);

		infoLogger.setFormatString(formatString);
		logger.log(ILogger.INFO, "Dette er en info-melding.", null);
		assertEquals(String.format(formatString, ILogger.INFO, "Dette er en info-melding.", null),
				infoStream.toString().trim(), "Teste formatet på info-melding etter logging");

		newInfoLogger.setFormatString(formatString);
		logger.setLogger(ILogger.INFO, newInfoLogger);
		logger.log(ILogger.INFO, "Dette er den andre info-meldingen.", null);
		assertEquals(String.format(formatString, ILogger.INFO, "Dette er en info-melding.", null),
				infoStream.toString().trim(),
				"Teste første info-strøm etter å ha byttet infologger og logget enda en info-melding");
		assertEquals(
				String.format(formatString, ILogger.INFO, "Dette er den andre info-meldingen.",
						null),
				newInfoStream.toString().trim(),
				"Teste andre info-strøm etter å ha byttet infologget og logget ny info-melding");
	}
}
