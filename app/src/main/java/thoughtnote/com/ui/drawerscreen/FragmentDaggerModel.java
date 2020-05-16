package thoughtnote.com.ui.drawerscreen;

import com.google.gson.Gson;
import thoughtnote.com.retro.GitHubService;
import thoughtnote.com.ui.entry.forgotPass.ForgotPassViewModel;
import thoughtnote.com.ui.entry.getstarted.GetStartedViewModel;
import thoughtnote.com.ui.entry.login.LoginViewModel;
import thoughtnote.com.ui.entry.resetPass.ResetPassViewModel;
import thoughtnote.com.ui.entry.resetPassSuccess.ResetPassSuccessViewModel;
import thoughtnote.com.ui.entry.signup.SignupViewModel;
import thoughtnote.com.utilz.Constants;
import thoughtnote.com.utilz.SharedPrefence;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mukesh on 07/05/20.
 */

@Module
public class FragmentDaggerModel {
    @Provides
    LoginViewModel provideLoginViewModel(@Named(Constants.ourApp) GitHubService gitHubService,
                                         SharedPrefence sharedPrefence,
                                         Gson gson) {
        return new LoginViewModel(gitHubService, sharedPrefence, gson);
    }

    @Provides
    SignupViewModel provideSignupViewModel(@Named(Constants.ourApp) GitHubService gitHubService,
                                           SharedPrefence sharedPrefence,
                                           Gson gson) {
        return new SignupViewModel(gitHubService, sharedPrefence, gson);
    }

    @Provides
    GetStartedViewModel provideGetStartedViewModel(@Named(Constants.ourApp) GitHubService gitHubService,
                                                   SharedPrefence sharedPrefence,
                                                   Gson gson) {
        return new GetStartedViewModel(gitHubService, sharedPrefence, gson);
    }

    @Provides
    ForgotPassViewModel provideForgotPassViewModel(@Named(Constants.ourApp) GitHubService gitHubService,
                                                   SharedPrefence sharedPrefence,
                                                   Gson gson) {
        return new ForgotPassViewModel(gitHubService, sharedPrefence, gson);
    }

    @Provides
    ResetPassViewModel provideResetPassViewModel(@Named(Constants.ourApp) GitHubService gitHubService,
                                                 SharedPrefence sharedPrefence,
                                                 Gson gson) {
        return new ResetPassViewModel(gitHubService, sharedPrefence, gson);
    }

    @Provides
    ResetPassSuccessViewModel provideResetPassSuccessViewModel(@Named(Constants.ourApp) GitHubService gitHubService,
                                                        SharedPrefence sharedPrefence,
                                                        Gson gson) {
        return new ResetPassSuccessViewModel(gitHubService, sharedPrefence, gson);
    }
}
