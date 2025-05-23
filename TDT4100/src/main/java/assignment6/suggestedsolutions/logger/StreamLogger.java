package assignment6.suggestedsolutions.logger;

import java.io.OutputStream;
import java.io.PrintStream;

public class StreamLogger implements ILogger {

	private final PrintStream stream;
	private String formatString = "%s: %s (%s)";

	public StreamLogger(OutputStream stream) {
		this.stream = new PrintStream(stream);
	}

	public void setFormatString(String formatString) {
		if (formatString == null) {
			throw new IllegalArgumentException("Format string cannot be null");
		}
		// Check if it contains exactly three "%s" substrings
		if (formatString.split("%s", -1).length != 4) {
			throw new IllegalArgumentException("Format string must contain exactly three %s");
		}

		this.formatString = formatString;
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		this.stream.format(this.formatString, severity, message, exception);
		this.stream.println();
		this.stream.flush();
	}
}
