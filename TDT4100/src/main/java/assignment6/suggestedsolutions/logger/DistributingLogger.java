package assignment6.suggestedsolutions.logger;

import java.util.HashMap;
import java.util.Map;

public class DistributingLogger implements ILogger {

	private final Map<String, ILogger> loggers = new HashMap<>();

	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
		this.setLogger(ILogger.ERROR, errorLogger);
		this.setLogger(ILogger.WARNING, warningLogger);
		this.setLogger(ILogger.INFO, infoLogger);
	}

	public void setLogger(String severity, ILogger logger) {
		this.loggers.put(severity, logger);
	}

	@Override
	public void log(String severity, String message, Exception e) {
		ILogger logger = this.loggers.get(severity);

		if (logger != null) {
			logger.log(severity, message, e);
		}
	}
}
