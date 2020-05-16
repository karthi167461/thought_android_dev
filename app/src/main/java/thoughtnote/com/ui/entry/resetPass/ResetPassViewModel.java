package thoughtnote.com.ui.entry.resetPass;


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

public class ResetPassViewModel extends BaseNetwork<BaseResponse, ResetPassNavigator> {

    public ResetPassViewModel(GitHubService gitHubService, SharedPrefence sharedPrefence, Gson gson) {
        super(gitHubService, sharedPrefence, gson);
    }

    public void onForgotPass(View view) {
        getmNavigator().navigateToForgotPass();
    }

    public void onChangePass(View view) {
        getmNavigator().navigateToChangePassSuccess();
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
