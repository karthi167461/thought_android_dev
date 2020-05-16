package thoughtnote.com.ui.drawerscreen;

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

public class DrawerViewModel extends BaseNetwork<BaseResponse, DrawerNavigator> {

    Gson gson;


    SharedPrefence sharedPrefence;

    @Inject
    HashMap<String, String> hashMap;

    @Inject
    public DrawerViewModel(@Named(Constants.ourApp) GitHubService gitHubService,
                           SharedPrefence sharedPrefence, Gson gson) {
        super(gitHubService, sharedPrefence, gson);
        this.sharedPrefence = sharedPrefence;
        this.gson = gson;
    }

    /**
     * Set profile data's from API to variables
     **/
    void setupProfile() {
    }

    @Override
    public void onSuccessfulApi(long taskId, BaseResponse response) {
        setIsLoading(false);
    }

    @Override
    public void onFailureApi(long taskId, CustomException e) {
        setIsLoading(false);
    }

    /**
     * {@link HashMap} with query parameters used for API calls
     **/
    @Override
    public HashMap<String, String> getMap() {
        return hashMap;
    }

}
