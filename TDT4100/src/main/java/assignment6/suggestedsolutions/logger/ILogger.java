package assignment6.suggestedsolutions.logger;

public interface ILogger {

	String ERROR = "error";
	String INFO = "info";
	String WARNING = "warning";

	void log(String severity, String message, Exception exception);
}
