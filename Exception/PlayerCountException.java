package TicTaeToe.Exception;

public class PlayerCountException extends RuntimeException{
    public PlayerCountException() {
        super();
    }

    public PlayerCountException(String message) {
        super(message);
    }

    public PlayerCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerCountException(Throwable cause) {
        super(cause);
    }

    protected PlayerCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
