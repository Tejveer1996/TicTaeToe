package TicTaeToe.Exception;

public class BotCountException extends RuntimeException {
    public BotCountException() {
        super();
    }

    public BotCountException(String message) {
        super(message);
    }

    public BotCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public BotCountException(Throwable cause) {
        super(cause);
    }

    protected BotCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
