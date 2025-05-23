package assignment6.solutions.delegation;

import java.util.ArrayList;
import java.util.List;

public class FilteringLogger implements ILogger {
    private List<String> severities;
    private ILogger logger;

    public FilteringLogger(ILogger logger, String... severities) {
        if (severities == null)
            throw new IllegalArgumentException("Severities cannot be null.");
        this.logger = logger;
        this.severities = new ArrayList<>(List.of(severities));
    }

    @Override
    public void log(String severity, String message, Exception exception) {
        if (severities.contains(severity))
            logger.log(severity, message, exception);
    }

    public boolean isLogging(String severity) {
        return severities.contains(severity);
    }

    public void setIsLogging(String severity, boolean value) {
        if (!severities.contains(severity) && value) {
            severities.add(severity);
        } else if (severities.contains(severity) && !value) {
            severities.remove(severity);
        }
    }
}
