package io.module.core.client.error;

/**
 * @author kiva
 */

public class ErrorInfo {
    public static ErrorInfo from(Throwable throwable) {
        return new ErrorInfo(throwable);
    }

    private Throwable throwable;

    private ErrorInfo(Throwable throwable) {
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
