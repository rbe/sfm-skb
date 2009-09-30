package de.sfhms.skb.processor;

/**
 *
 * @author rbe
 */
public class ProcessorException extends Exception {

    public ProcessorException(Throwable cause) {
        super(cause);
    }

    public ProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessorException(String message) {
        super(message);
    }
}
