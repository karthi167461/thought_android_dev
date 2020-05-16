package thoughtnote.com.ui.entry;

import android.os.Bundle;

import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.FragmentManager;

import thoughtnote.com.R;
import thoughtnote.com.databinding.ActivityEntryBinding;
import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.entry.forgotPass.ForgotPassFragment;
import thoughtnote.com.ui.entry.getstarted.GetStartedFragment;
import thoughtnote.com.ui.entry.login.LoginFragment;
import thoughtnote.com.ui.entry.resetPass.ResetPassFragment;
import thoughtnote.com.ui.entry.resetPassSuccess.ResetPassSuccessFragment;
import thoughtnote.com.ui.entry.signup.SignupFragment;
import thoughtnote.com.utilz.SharedPrefence;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class EntryAct extends BaseActivity<ActivityEntryBinding, EntryActViewModel>
        implements EntryActNavigator, HasAndroidInjector {
    private static final String TAG = "EntryAct";
    @Inject
    EntryActViewModel entryActViewModel;
    @Inject
    SharedPrefence sharedPrefence;
    @Inject
    DispatchingAndroidInjector<Object> fragmentDispatchingAndroidInjector;
    FragmentManager fragmentManager;
    ActivityEntryBinding activity_entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity_entry = getViewDataBinding();
        entryActViewModel.setNavigator(this);
        fragmentManager = getSupportFragmentManager();
        setUp();
    }


    @Override
    public EntryActViewModel getViewModel() {
        return entryActViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_entry;
    }

    @Override
    public SharedPrefence getSharedPrefence() {
        return sharedPrefence;
    }

    private void setUp() {
        openGetStartedFragment(false);
        getGCMDeviceToken();
    }

    /**
     * Called when logout is clicked
     **/
    @Override
    public void logout() {

    }

    public void openLoginFragment(boolean transmission) {
        if (transmission)
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.Container, LoginFragment.newInstance(), LoginFragment.TAG)
                    .commitAllowingStateLoss();
        else
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .replace(R.id.Container, LoginFragment.newInstance(), LoginFragment.TAG)
                    .commitAllowingStateLoss();
    }

    public void openSignupFragment(boolean transmission) {
        if (transmission)
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.Container, SignupFragment.newInstance(), SignupFragment.TAG)
                    .commitAllowingStateLoss();
        else
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .replace(R.id.Container, SignupFragment.newInstance(), SignupFragment.TAG)
                    .commitAllowingStateLoss();
    }

    public void openGetStartedFragment(boolean transmission) {
        if (transmission)
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.Container, GetStartedFragment.newInstance(), GetStartedFragment.TAG)
                    .commitAllowingStateLoss();
        else
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .replace(R.id.Container, GetStartedFragment.newInstance(), GetStartedFragment.TAG)
                    .commitAllowingStateLoss();
    }

    public void openForgotPass(boolean transmission) {
        if (transmission)
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.Container, ForgotPassFragment.newInstance(), ForgotPassFragment.TAG)
                    .commitAllowingStateLoss();
        else
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .replace(R.id.Container, ForgotPassFragment.newInstance(), ForgotPassFragment.TAG)
                    .commitAllowingStateLoss();
    }

    public void openResetPass(boolean transmission) {
        if (transmission)
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.Container, ResetPassFragment.newInstance(), ResetPassFragment.TAG)
                    .commitAllowingStateLoss();
        else
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .replace(R.id.Container, ResetPassFragment.newInstance(), ResetPassFragment.TAG)
                    .commitAllowingStateLoss();
    }
    public void openResetPassSuccess(boolean transmission) {
        if (transmission)
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.Container, ResetPassSuccessFragment.newInstance(), ResetPassSuccessFragment.TAG)
                    .commitAllowingStateLoss();
        else
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .replace(R.id.Container, ResetPassSuccessFragment.newInstance(), ResetPassSuccessFragment.TAG)
                    .commitAllowingStateLoss();
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return fragmentDispatchingAndroidInjector;
    }

}
