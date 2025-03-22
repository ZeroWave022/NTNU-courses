package assignment6.delegation;

public interface ILogger {
    String ERROR = "ERROR";
    String WARNING = "WARNING";
    String INFO = "INFO";

    void log(String severity, String message, Exception exception);
}
