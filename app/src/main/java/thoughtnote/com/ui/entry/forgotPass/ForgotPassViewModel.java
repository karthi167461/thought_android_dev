package thoughtnote.com.ui.entry.forgotPass;


import android.view.View;

import com.google.gson.Gson;
import thoughtnote.com.retro.GitHubService;
import thoughtnote.com.retro.base.BaseNetwork;
import thoughtnote.com.retro.base.BaseResponse;
import thoughtnote.com.utilz.SharedPrefence;
import thoughtnote.com.utilz.exception.CustomException;

import java.util.HashMap;

/**
 * Created by Mukesh on 07/05/20.
 */

public class ForgotPassViewModel extends BaseNetwork<BaseResponse, ForgotPassNavigator> {

    public ForgotPassViewModel(GitHubService gitHubService, SharedPrefence sharedPrefence, Gson gson) {
        super(gitHubService, sharedPrefence, gson);
    }

    public void onLogin(View view) {
        getmNavigator().navigateToLogin();
    }
    public void onResetPass(View view) {
        getmNavigator().navigateToResetPass();
    }

    @Override
    public void onSuccessfulApi(long taskId, BaseResponse response) {
        setIsLoading(false);
    }

    @Override
    public void onFailureApi(long taskId, CustomException e) {
        setIsLoading(false);
        getmNavigator().showMessage(e.getMessage());
    }

    @Override
    public HashMap<String, String> getMap() {
        return null;
    }
}
