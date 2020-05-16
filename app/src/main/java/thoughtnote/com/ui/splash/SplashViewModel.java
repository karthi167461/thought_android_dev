package thoughtnote.com.ui.splash;

import androidx.databinding.ObservableBoolean;

import com.google.gson.Gson;
import thoughtnote.com.retro.GitHubService;
import thoughtnote.com.retro.base.BaseNetwork;
import thoughtnote.com.retro.base.BaseResponse;
import thoughtnote.com.utilz.Constants;
import thoughtnote.com.utilz.SharedPrefence;
import thoughtnote.com.utilz.exception.CustomException;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by root on 10/11/17.
 */

public class SplashViewModel extends BaseNetwork<BaseResponse, SplashNavigator> {
    SharedPrefence sharedPrefence;
    Gson gson;
    public ObservableBoolean isLoaad = new ObservableBoolean(false);


    @Inject
    public SplashViewModel(@Named(Constants.ourApp) GitHubService gitHubService
            , SharedPrefence sharedPrefence, Gson gson) {
        super(gitHubService, sharedPrefence, gson);
        this.sharedPrefence = sharedPrefence;
        this.gson = gson;

    }


    /**
     * @param taskId
     * @param response holds the response getting the language.
     */
    @Override
    public void onSuccessfulApi(long taskId, BaseResponse response) {
        // setIsLoading(false);
        isLoaad.set(false);
//        if (response.success) {
//            if (response.data != null) {
//                response.saveLanguageTranslations(sharedPrefence, gson, response.data);
//            }
//            getmNavigator().startRequestingPermissions();
//        }

    }

    /**
     * @param taskId
     * @param e      holds the exception messages from Api.
     */
    @Override
    public void onFailureApi(long taskId, CustomException e) {
        //setIsLoading(false);
        isLoaad.set(false);

        getmNavigator().showMessage(e.getMessage());
        getmNavigator().startRequestingPermissions();
    }

    @Override
    public HashMap<String, String> getMap() {
        return null;
    }

    /**
     * Api call for getting the languages.
     */
    public void getLanguagees() {
        if (getmNavigator().isNetworkConnected()) {
            // setIsLoading(true);
            isLoaad.set(true);
//            getTranslations();
        } else
            getmNavigator().showNetworkMessage();
    }
}
