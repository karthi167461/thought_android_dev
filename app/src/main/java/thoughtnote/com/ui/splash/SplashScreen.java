package thoughtnote.com.ui.splash;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import thoughtnote.com.BR;
import thoughtnote.com.R;
import thoughtnote.com.databinding.SplashscreenBinding;
import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.drawerscreen.DrawerAct;
import thoughtnote.com.ui.entry.EntryAct;
import thoughtnote.com.utilz.CommonUtils;
import thoughtnote.com.utilz.Constants;
import thoughtnote.com.utilz.SharedPrefence;
import thoughtnote.com.utilz.language.LanguageUtil;

import java.security.MessageDigest;
import java.util.Locale;

import javax.inject.Inject;

//import org.jsoup.Jsoup;


/**
 * Created by naveen on 8/24/17.
 */

public class SplashScreen extends BaseActivity<SplashscreenBinding, SplashViewModel> implements SplashNavigator {
    @Inject
    SplashViewModel emptyViewModel;

    @Inject
    SharedPrefence sharedPrefence;
    String language = "";
    SplashscreenBinding binding;

    //    GetVersionCode getVersionCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getGCMDeviceToken();
        binding = getViewDataBinding();
//        if (binding != null && binding.imgSpl != null)
//            Glide.with(this).load(R.raw.ic_launch_animation).into(binding.imgSpl);
        emptyViewModel.setNavigator(this);
        startRequestingPermissions();
        /*configureLanguage();

        Resources resources = MyApp.getmContext().getResources();
        Configuration config = resources.getConfiguration();

        //get phone language
        if (config.locale.toString().contains("_")) {
            String[] phoneLang = config.locale.toString().split("_");
            Log.e("Phonelang===", phoneLang[0]);
            language = phoneLang[0];
        } else language = config.locale.toString();

//        emptyViewModel.getLanguagees();*/
//        getKeyHash();
    }

    /**
     * Get HaskKey for facebook login.
     */
    private void getKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("KeyHash==", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (Exception e) {
            Log.e("KeyHash==", "printHashKey()", e);
        }
    }

    /**
     * Set the app default language.
     */
    private void configureLanguage() {
        if (CommonUtils.IsEmpty(sharedPrefence.Getvalue(SharedPrefence.LANGUANGE)))
            sharedPrefence.savevalue(SharedPrefence.LANGUANGE, "en");

        String localLanguageType = sharedPrefence.Getvalue(SharedPrefence.LANGUANGE);

        if ("ar".equals(localLanguageType)) {
            Locale locale = Locale.getDefault();
            Locale.setDefault(new Locale("ar"));
            LanguageUtil.changeLanguageType(this, locale);
        } else if (!TextUtils.isEmpty(localLanguageType)) {
            Locale locale = Locale.getDefault();
            Locale.setDefault(new Locale(localLanguageType));
            LanguageUtil.changeLanguageType(this, locale);
        } else {
            LanguageUtil.changeLanguageType(this, Locale.ENGLISH);
        }
    }

    @Override
    public SplashViewModel getViewModel() {
        return emptyViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.splashscreen;
    }

    @Override
    public SharedPrefence getSharedPrefence() {
        return sharedPrefence;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if ((requestCode == Constants.REQUEST_PERMISSION) && checkGranted(grantResults)) {
            startActivity(new Intent(SplashScreen.this, DrawerAct.class));
            finish();
        } else {
            alertCalling();
        }

    }


    /**
     * Runnable to move on launch screens.
     */
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            /*if (!CommonUtils.isGpscheck(SplashScreen.this)) {
                CommonUtils.ShowGpsDialog(SplashScreen.this);

            } else */
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !checkGranted(Constants.Array_permissions)) {
//                requestPermissionsSafely(Constants.Array_permissions, Constants.REQUEST_PERMISSION);
//            } else {
            startActivity(new Intent(SplashScreen.this, EntryAct.class));
            finish();

//            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Alert for location permissions.
     */
    private void alertCalling() {
        AlertDialog ad = new AlertDialog.Builder(this)
                .setTitle(getTranslatedString(R.string.Alert_title_Permission))
                .setCancelable(false)
                .setMessage(getTranslatedString(R.string.Alert_Msg_Location))
                .setPositiveButton(getTranslatedString(R.string.Txt_Continue), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        requestPermissionsSafely(Constants.Array_permissions, Constants.REQUEST_PERMISSION);

                    }
                })
                .setNegativeButton(R.string.Txt_Exit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .create();
        if (!isFinishing())
            ad.show();
    }

    @Override
    public BaseActivity getAttachedContext() {
        return this;
    }

    /**
     * set the delaying for 4 seconds, after 4 seconds the runnable methods called..
     */
    @Override
    public void startRequestingPermissions() {
        new Handler().postDelayed(runnable, 4000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !checkGranted(Constants.Array_permissions)) {
            requestPermissionsSafely(Constants.Array_permissions, Constants.REQUEST_PERMISSION);
        } else
            initiateNaviagation();
    }

    /**
     * set the app launches.
     */
    private void initiateNaviagation() {
        startActivity(new Intent(SplashScreen.this, DrawerAct.class));
        finish();
    }

}