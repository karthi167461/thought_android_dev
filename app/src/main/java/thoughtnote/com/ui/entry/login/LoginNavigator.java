package thoughtnote.com.ui.entry.login;

import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.base.BaseView;

/**
 * Created by Mukesh on 07/05/20.
 */

public interface LoginNavigator extends BaseView {
    public BaseActivity getAttachedContext();

    void navigateToRegister();
    void navigateToForgotPass();
}
