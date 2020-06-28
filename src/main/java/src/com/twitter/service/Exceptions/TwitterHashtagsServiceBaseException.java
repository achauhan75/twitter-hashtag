package src.com.twitter.service.Exceptions;


/**
 *
 * This is a broad exception class. If specific exception needs to be caught then use similar 
 */
public abstract class TwitterHashtagsServiceBaseException extends Exception {
    private String message = null;
    private int statusCode;
    private Exception baseException;

    /**
     *
     */
    public TwitterHashtagsServiceBaseException() {
        super();
    }

    /**
     *
     * @param message
     * @param statusCode
     * @param baseException
     */
    public TwitterHashtagsServiceBaseException(String message, int statusCode, Exception baseException) {
        super(message, baseException);
        this.message = message;
        this.statusCode = statusCode;
        this.baseException = baseException;
    }

    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }

    /**
     *
     * @return
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     *
     * @return
     */
    public Exception getBaseException() {
        return baseException;
    }
}

