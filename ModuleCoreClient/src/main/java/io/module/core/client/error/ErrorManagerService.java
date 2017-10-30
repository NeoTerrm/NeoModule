package io.module.core.client.error;

/**
 * @author kiva
 */

public interface ErrorManagerService {
    void reportError(ErrorInfo errorInfo);

    void registerErrorHandler(ErrorHandler errorHandler);

    void unregisterErrorHandler(ErrorHandler errorHandler);
}
