package src.com.twitter.service.Exceptions;

/**
 * TwitterServiceNotFoundException
 */
public class TwitterHashtagsServiceNotFoundException extends TwitterHashtagsServiceBaseException {
    public static final int NOT_FOUND_404 = 404;
    /**
     *
     */
    public TwitterHashtagsServiceNotFoundException() {
        super();
    }

    /**
     *
     * @param message
     */
    public TwitterHashtagsServiceNotFoundException(String message) {
        super(message, NOT_FOUND_404, null);
    }

    /**
     *
     * @param message
     * @param baseException
     */
    public TwitterHashtagsServiceNotFoundException(String message, Exception baseException) {
        super(message, NOT_FOUND_404, baseException);
    }

}
