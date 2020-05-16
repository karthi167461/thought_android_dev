package thoughtnote.com.ui.drawerscreen;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import thoughtnote.com.ui.entry.forgotPass.ForgotPassFragment;
import thoughtnote.com.ui.entry.getstarted.GetStartedFragment;
import thoughtnote.com.ui.entry.login.LoginFragment;
import thoughtnote.com.ui.entry.resetPass.ResetPassFragment;
import thoughtnote.com.ui.entry.resetPassSuccess.ResetPassSuccessFragment;
import thoughtnote.com.ui.entry.signup.SignupFragment;

/**
 * Created by root on 10/11/17.
 */
@Module
public abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = FragmentDaggerModel.class)
    abstract LoginFragment provideLoginFragment();

    @ContributesAndroidInjector(modules = FragmentDaggerModel.class)
    abstract SignupFragment provideSignupFragment();

    @ContributesAndroidInjector(modules = FragmentDaggerModel.class)
    abstract GetStartedFragment provideGetStartedFragment();

    @ContributesAndroidInjector(modules = FragmentDaggerModel.class)
    abstract ForgotPassFragment provideForgotPassFragment();

    @ContributesAndroidInjector(modules = FragmentDaggerModel.class)
    abstract ResetPassFragment provideFResetPassFragment();

    @ContributesAndroidInjector(modules = FragmentDaggerModel.class)
    abstract ResetPassSuccessFragment provideResetPassSuccessFragment();
}
