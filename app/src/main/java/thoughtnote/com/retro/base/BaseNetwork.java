package thoughtnote.com.retro.base;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;

import com.google.gson.Gson;
import thoughtnote.com.retro.GitHubService;
import thoughtnote.com.retro.responsemodel.TranslationModel;
import thoughtnote.com.utilz.CommonUtils;
import thoughtnote.com.utilz.Constants;
import thoughtnote.com.utilz.SharedPrefence;
import thoughtnote.com.utilz.exception.CustomException;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 9/27/17.
 */

/**
 * Here is where all API calls connected with view and githubService
 **/
public abstract class BaseNetwork<T extends BaseResponse, N> implements Basecallback<T> {

    public GitHubService gitHubService;
    private N mNavigator;
    public HashMap<String, RequestBody> requestbody = new HashMap<>();
    public MultipartBody.Part body = null;
    /*public  ObservableInt mCurrentTaskId = new ObservableInt(-1);*/
    public final Integer mCurrentTaskId = -1;
    public ObservableBoolean mIsLoading = new ObservableBoolean(false);
    public TranslationModel translationModel;
    public SharedPrefence sharedPrefence;
    public Gson gson;

    /**
     * @param gitHubService is intiating the api parameter.
     */
    public BaseNetwork(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    /**
     * @param gitHubService  object of GithubService class for api.
     * @param sharedPrefence object of SharedPreference and to used Every Viewmodel class.
     * @param gson           object of Gson and this is for getting the Translation Model.
     */
    public BaseNetwork(GitHubService gitHubService, SharedPrefence sharedPrefence, Gson gson) {
        this.gitHubService = gitHubService;
        this.sharedPrefence = sharedPrefence;
        this.gson = gson;
        if (!CommonUtils.IsEmpty(sharedPrefence.Getvalue(SharedPrefence.LANGUANGE))) {
            translationModel = gson.fromJson(sharedPrefence.Getvalue(sharedPrefence.Getvalue(SharedPrefence.LANGUANGE)), TranslationModel.class);
        }
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /**
     * Api call to delete the Favourite Address.
     */
    public void DeleteFavNetworkcall() {
//        gitHubService.DeleteFav(getMap()).enqueue((Callback<BaseResponse>) baseModelCallBackListener);
    }


    /**
     * Api callback to detect the Api response whether success or failure.
     */
    private Callback<T> baseModelCallBackListener = new Callback<T>() {
        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if (response.isSuccessful() && response.body() != null) {

                if (response.body().success) {

                    onSuccessfulApi(mCurrentTaskId, response.body());
                } else {
                    onFailureApi(mCurrentTaskId, new CustomException(response.body().errorCode, response.body().errorMessage));
                }
            } else {
                onFailureApi(mCurrentTaskId, new CustomException(500, Constants.HttpErrorMessage.INTERNAL_SERVER_ERROR));
            }

        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {

            onFailureApi(mCurrentTaskId, new CustomException(501, t.getLocalizedMessage()));
        }
    };

    public abstract HashMap<String, String> getMap();

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    /**
     * @param isLoading contains whether loader is need ot not.
     */
    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    /**
     * @param navigator is the inter
     */
    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

    public N getmNavigator() {
        return mNavigator;
    }


    @BindingAdapter({"bind:textfont"})
    public static void settextFont(TextView textView, String fontName) {
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + fontName));
    }

    @BindingAdapter({"bind:Editfont"})
    public static void setEditFont(EditText textView, String fontName) {
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + fontName));
    }


    @BindingAdapter({"bind:Buttonfont"})
    public static void setButtonFont(Button textView, String fontName) {
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + fontName));
    }

    /**
     * @param v hide the opened keyboard.
     */
    public void hideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

}
