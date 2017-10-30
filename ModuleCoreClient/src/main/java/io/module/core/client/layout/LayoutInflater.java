package io.module.core.client.layout;

import android.view.View;
import android.view.ViewGroup;

import java.io.InputStream;

/**
 * @author kiva
 */

public interface LayoutInflater {
    View inflateStream(InputStream stream, ViewGroup parent);
}
