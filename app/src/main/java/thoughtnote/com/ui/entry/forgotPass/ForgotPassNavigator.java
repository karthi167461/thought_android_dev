package thoughtnote.com.ui.entry.forgotPass;

import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.base.BaseView;

/**
 * Created by Mukesh on 07/05/20.
 */

public interface ForgotPassNavigator extends BaseView {
    public BaseActivity getAttachedContext();

    void navigateToLogin();

    void navigateToResetPass();
}
