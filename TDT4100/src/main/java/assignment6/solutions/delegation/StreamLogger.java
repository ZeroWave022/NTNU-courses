package assignment6.solutions.delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {
    private OutputStream stream;
    private String formatString = "%s: %s. %s\n";

    public StreamLogger(OutputStream stream) {
        this.stream = stream;
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        try {
            stream.write(String.format(formatString, severity, message, exception).getBytes());
            stream.flush();
        } catch (IOException ioe) {
            System.out.println("Couldn't write to stream: " + ioe);
        }
    }

    public void setFormatString(String formatString) {
        if (formatString == null)
            throw new IllegalArgumentException("Format string cannot be null.");
        this.formatString = formatString;
    }

    public static void main(String[] args) {
        StreamLogger logger = new StreamLogger(System.out);
        logger.log(ILogger.ERROR, "Error message", new IllegalArgumentException("Some argument was illegal"));
        logger.log(ILogger.ERROR, "Error message", new IllegalArgumentException("Some argument was illegal"));
        logger.log(ILogger.ERROR, "Error message", new IllegalArgumentException("Some argument was illegal"));
    }
}
