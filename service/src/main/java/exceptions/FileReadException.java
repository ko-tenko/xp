package exceptions;

public class FileReadException extends FileException {

    public FileReadException() {}

    public FileReadException(String message) {
        super(message);
    }

    public FileReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
