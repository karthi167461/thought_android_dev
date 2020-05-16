package thoughtnote.com.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;
import thoughtnote.com.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import io.fabric.sdk.android.Fabric;

/**
 * Created by root on 9/22/17.
 */

public class MyApp extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;
    private static Context mContext;

    Activity topDriverAct;
    static boolean isDriverEnabled = false;
    static boolean isNodDriveActDestroyed = true;

    @Override
    public void onCreate() {
        super.onCreate();
        initiatingCrashlytics();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        mContext = this;
    }

    public static Context getmContext() {
        return mContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /**
     * initialize crashlytics Fabric
     **/
    private void initiatingCrashlytics() {
        Fabric.with(this, new Crashlytics());
        // TODO: Move this to where you establish a user session
        logUser();
    }

    /**
     * login to crashlytics
     **/
    private void logUser() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier("12345");
        Crashlytics.setUserEmail("user@fabric.io");
        Crashlytics.setUserName("ThoughtNote");
    }

    public static boolean isIsNodDriveActDestroyed() {
        return isNodDriveActDestroyed;
    }

    public static void setIsNodDriveActDestroyed(boolean isNodDriveActDestroyed) {
        MyApp.isNodDriveActDestroyed = isNodDriveActDestroyed;
    }

    public static boolean clearMethd() {
        return isDriverEnabled;
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return activityDispatchingAndroidInjector;
    }
}
