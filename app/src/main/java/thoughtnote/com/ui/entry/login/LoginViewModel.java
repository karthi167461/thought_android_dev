package thoughtnote.com.ui.entry.login;


import android.view.View;

import androidx.databinding.ObservableField;

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

public class LoginViewModel extends BaseNetwork<BaseResponse, LoginNavigator> {
    public ObservableField<String> userPic = new ObservableField<>();
    public ObservableField<String> userName = new ObservableField<>();
    GitHubService gitHubService;
    HashMap<String, String> map = new HashMap<>();

    public LoginViewModel(GitHubService gitHubService, SharedPrefence sharedPrefence, Gson gson) {
        super(gitHubService, sharedPrefence, gson);
//        DataBindingUtil.setDefaultComponent(new MyDataComponent(this));
        this.gson = gson;
    }

    public void onRegister(View view) {
        if (validataion()) {
            setIsLoading(true);
//            reviewUser();
            getmNavigator().navigateToRegister();
        }
    }

    public void onForgotPass(View view) {
        getmNavigator().navigateToForgotPass();
    }

    public boolean validataion() {
        String msg = null;
//        if (userReview.get() > 0 && userReview.get() < 3 && txt_comments.get().isEmpty()) {
//            msg = "Comments cannot be left empty!";
//        }
        if (msg != null) {
            getmNavigator().showMessage(msg);
            return false;
        }
        return true;
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
        return map;
    }
}
