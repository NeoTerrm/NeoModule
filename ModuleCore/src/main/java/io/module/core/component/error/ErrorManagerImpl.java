package io.module.core.component.error;

import io.module.core.client.error.ErrorHandler;
import io.module.core.client.error.ErrorInfo;
import io.module.core.client.error.ErrorManager;

/**
 * @author kiva
 */

public class ErrorManagerImpl implements ErrorManager {
    private ErrorDispatcher errorDispatcher = new ErrorDispatcher();

    @Override
    public void reportError(ErrorInfo errorInfo) {
        errorDispatcher.obtainMessage(ErrorDispatcher.MSG_DISPATCH, errorInfo)
                .sendToTarget();
    }

    @Override
    public void registerErrorHandler(ErrorHandler errorHandler) {
        errorDispatcher.obtainMessage(ErrorDispatcher.MSG_REGISTER_HANDLER, errorHandler)
                .sendToTarget();
    }

    @Override
    public void unregisterErrorHandler(ErrorHandler errorHandler) {
        errorDispatcher.obtainMessage(ErrorDispatcher.MSG_UNREGISTER_HANDLER, errorHandler)
                .sendToTarget();
    }
}
