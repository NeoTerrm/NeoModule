package io.module.core.client.error;

/**
 * @author kiva
 */

public interface ErrorHandler {
    boolean onHandleError(ErrorInfo errorInfo);
}
