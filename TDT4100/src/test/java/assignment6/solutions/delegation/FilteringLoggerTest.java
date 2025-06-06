package assignment6.solutions.delegation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilteringLoggerTest {

	private ByteArrayOutputStream stream;
	private StreamLogger subLogger;

	@BeforeEach
	public void setUp() {
		stream = new ByteArrayOutputStream();
		subLogger = new StreamLogger(stream);
	}

	@Test
	@DisplayName("Lage logger uten alvorlighetsgrader")
	public void testFilteringLoggerNoSeverities() {
		FilteringLogger logger = new FilteringLogger(subLogger);
		assertFalse(logger.isLogging(ILogger.INFO),
				"Teste logger uten alvorlighetsgrad for info-logging");
		assertFalse(logger.isLogging(ILogger.WARNING),
				"Teste logger uten alvorlighetsgrad for warning-logging");
		assertFalse(logger.isLogging(ILogger.ERROR),
				"Teste logger uten alvorlighetsgrad for error-logging");
	}

	@Test
	@DisplayName("Lage logger med error og info")
	public void testFilteringLoggerErrorAndInfo() {
		FilteringLogger logger = new FilteringLogger(subLogger, ILogger.ERROR, ILogger.INFO);
		assertTrue(logger.isLogging(ILogger.INFO), "Teste error- og info-logger for info-logging");
		assertFalse(logger.isLogging(ILogger.WARNING),
				"Teste error- og info-logger for warning-logging");
		assertTrue(logger.isLogging(ILogger.ERROR),
				"Teste error- og info-logger for error-logging");
	}

	@Test
	@DisplayName("Lage logger med warning, sette error")
	public void testFilteringLoggerWarningSetIsLoggingError() {
		FilteringLogger logger = new FilteringLogger(subLogger, ILogger.WARNING);
		assertFalse(logger.isLogging(ILogger.INFO), "Teste warning-logger for info-logging");
		assertTrue(logger.isLogging(ILogger.WARNING), "Teste warning-logger for warning-logging");
		assertFalse(logger.isLogging(ILogger.ERROR), "Teste warning-logger for error-logging");

		logger.setIsLogging(ILogger.ERROR, true);
		assertFalse(logger.isLogging(ILogger.INFO),
				"Sette error-logging for warning-logger og teste for info-logging");
		assertTrue(logger.isLogging(ILogger.WARNING),
				"Sette error-logging for warning-logger og teste for warning-logging");
		assertTrue(logger.isLogging(ILogger.ERROR),
				"Sette error-logging for warning-logger og error for info-logging");
	}

	@Test
	@DisplayName("Logger med alvorlighetsgrad ERROR")
	public void testErrorLogging() {
		IllegalStateException exception = new IllegalStateException();
		FilteringLogger logger = new FilteringLogger(subLogger, ILogger.ERROR);
		String formatString = "%s: %s (%s)";

		subLogger.setFormatString(formatString);
		logger.log(ILogger.ERROR, "Noe er feil!", exception);
		assertEquals(String.format(formatString, ILogger.ERROR, "Noe er feil!", exception),
				stream.toString().trim(), "Teste formatet på error-melding etter logging");
	}

	@Test
	@DisplayName("Logger med alvorlighetsgrad INFO i ERROR-logger")
	public void testInfoToErrorLogger() {
		IllegalStateException exception = new IllegalStateException();
		FilteringLogger logger = new FilteringLogger(subLogger, ILogger.ERROR);
		String formatString = "%s: %s (%s)";

		subLogger.setFormatString(formatString);
		logger.log(ILogger.INFO, "Noe er feil!", exception);
		assertEquals("", stream.toString(),
				"Teste strømmen etter å ha logget info-melding i error-logger");
	}
}
