package exceptions;

public class FileWriteException extends FileException {

    public FileWriteException() {}

    public FileWriteException(String message) {
        super(message);
    }

    public FileWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
