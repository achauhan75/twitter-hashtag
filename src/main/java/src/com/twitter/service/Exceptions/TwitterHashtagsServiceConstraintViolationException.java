package src.com.twitter.service.Exceptions;

/**
 * TwitterServiceConstraintViolationException
 */
public class TwitterHashtagsServiceConstraintViolationException extends TwitterHashtagsServiceBaseException {
    public static final int UNPROCESSABLE_ENTITY_422 = 422;

    /**
     *
     */
    public TwitterHashtagsServiceConstraintViolationException() {
        super();
    }

    /**
     * @param message
     */
    public TwitterHashtagsServiceConstraintViolationException(String message) {
        super(message, UNPROCESSABLE_ENTITY_422, null);
    }

    /**
     * @param message
     * @param baseException
     */
    public TwitterHashtagsServiceConstraintViolationException(String message, Exception baseException) {
        super(message, UNPROCESSABLE_ENTITY_422, baseException);
    }
}
