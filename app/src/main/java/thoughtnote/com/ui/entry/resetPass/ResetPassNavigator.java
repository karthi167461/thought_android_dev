package thoughtnote.com.ui.entry.resetPass;

import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.base.BaseView;

/**
 * Created by Mukesh on 07/05/20.
 */

public interface ResetPassNavigator extends BaseView {
    public BaseActivity getAttachedContext();

    void navigateToForgotPass();

    void navigateToChangePassSuccess();
}
