package assignment6.suggestedsolutions.logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilteringLogger implements ILogger {

	private final Collection<String> severities;
	private final ILogger logger;

	public FilteringLogger(ILogger logger, String... severities) {
		this.severities = new ArrayList<>(List.of(severities));
		this.logger = logger;
	}

	public boolean isLogging(String severity) {
		return this.severities.contains(severity);
	}

	public void setIsLogging(String severity, boolean value) {
		if (!value) {
			this.severities.remove(severity);
		} else if (!this.isLogging(severity)) {
			this.severities.add(severity);
		}
	}

	@Override
	public void log(String severity, String message, Exception e) {
		if (this.isLogging(severity)) {
			this.logger.log(severity, message, e);
		}
	}
}
