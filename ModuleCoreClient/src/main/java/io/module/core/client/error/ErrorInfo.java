package io.module.core.client.error;

/**
 * @author kiva
 */

public class ErrorInfo {
    private Throwable throwable;


    public ErrorInfo(Throwable throwable) {
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
