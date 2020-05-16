package thoughtnote.com.ui.splash;

import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.base.BaseView;

/**
 * Created by root on 10/11/17.
 */

public interface SplashNavigator extends BaseView {
    BaseActivity getAttachedContext();
    void startRequestingPermissions();
}
