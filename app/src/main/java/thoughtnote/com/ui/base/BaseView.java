package thoughtnote.com.ui.base;

import android.view.View;

import androidx.annotation.NonNull;

import thoughtnote.com.utilz.exception.CustomException;

/**
 * Created by root on 9/28/17.
 */

public interface BaseView {
    void showMessage(String message);

    void showMessage(int resId);

    void showMessage(CustomException e);

    void showSnackBar(String message);

    void showSnackBar(@NonNull View view, String message);

    boolean isNetworkConnected();

    void showNetworkMessage();
}
