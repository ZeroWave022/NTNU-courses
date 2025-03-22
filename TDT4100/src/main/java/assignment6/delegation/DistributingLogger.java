package assignment6.delegation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistributingLogger implements ILogger {
    private Map<String, ILogger> loggers;

    public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
        if (Arrays.asList(errorLogger, warningLogger, infoLogger).contains(null))
            throw new IllegalArgumentException("No logger can be null");
        this.loggers = new HashMap<>(Map.of("ERROR", errorLogger, "WARNING", warningLogger, "INFO", infoLogger));
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        ILogger loggerToUse = loggers.get(severity);
        if (loggerToUse == null)
            throw new IllegalArgumentException("Severity can only be \"ERROR\", \"WARNING\" or \"INFO\".");
        loggerToUse.log(severity, message, exception);
    }

    public void setLogger(String severity, ILogger logger) {
        if (!loggers.keySet().contains(severity))
            throw new IllegalArgumentException("Severity can only be \"ERROR\", \"WARNING\" or \"INFO\".");
        loggers.put(severity, logger);
    }
}
