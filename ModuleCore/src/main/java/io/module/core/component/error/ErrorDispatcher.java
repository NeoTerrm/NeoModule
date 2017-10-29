package io.module.core.component.error;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;

import io.module.core.NeoModuleConfig;
import io.module.core.client.error.ErrorHandler;
import io.module.core.client.error.ErrorInfo;
import io.module.core.runtime.NeoModuleLog;

/**
 * @author kiva
 */

class ErrorDispatcher extends Handler {
    private static final String TAG = ErrorDispatcher.class.getSimpleName();

    static final int MSG_DISPATCH = 1;
    static final int MSG_REGISTER_HANDLER = 2;
    static final int MSG_UNREGISTER_HANDLER = 3;

    private List<ErrorHandler> errorHandlerList;
    private List<ErrorInfo> unhandledErrors;

    ErrorDispatcher() {
        super(Looper.getMainLooper());
        errorHandlerList = new ArrayList<>(NeoModuleConfig.CONTAINER_INITIAL_CAPACITY);
        unhandledErrors = new ArrayList<>(NeoModuleConfig.CONTAINER_INITIAL_CAPACITY);
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_DISPATCH:
                if (msg.obj != null && msg.obj instanceof ErrorInfo) {
                    dispatchError(((ErrorInfo) msg.obj));
                } else {
                    NeoModuleLog.e(TAG, "Attempt to dispatch a unknown object as an error");
                }
                break;

            case MSG_REGISTER_HANDLER:
            case MSG_UNREGISTER_HANDLER:
                if (msg.obj != null && msg.obj instanceof ErrorHandler) {
                    ErrorHandler errorHandler = ((ErrorHandler) msg.obj);
                    if (msg.what == MSG_REGISTER_HANDLER) {
                        registerHandler(errorHandler);
                    } else if (msg.what == MSG_UNREGISTER_HANDLER) {
                        unregisterHandler(errorHandler);
                    }
                }
                break;

            default:
                super.handleMessage(msg);
                break;
        }
    }

    private void registerHandler(ErrorHandler errorHandler) {
        if (errorHandlerList.indexOf(errorHandler) != -1) {
            return;
        }

        errorHandlerList.add(errorHandler);
    }

    private void unregisterHandler(ErrorHandler errorHandler) {
        errorHandlerList.remove(errorHandler);
    }

    private void dispatchError(ErrorInfo errorInfo) {
        // dispatch unhandled ones first
        for (ErrorInfo error : unhandledErrors) {
            if (deliverError(error)) {
                unhandledErrors.remove(error);
            }
        }

        if (!deliverError(errorInfo)) {
            unhandledErrors.add(errorInfo);
        }
    }

    private boolean deliverError(ErrorInfo errorInfo) {
        for (ErrorHandler handler : errorHandlerList) {
            if (handler.onHandleError(errorInfo)) {
                return true;
            }
        }
        return false;
    }
}
