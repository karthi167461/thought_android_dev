package thoughtnote.com.ui.drawerscreen;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.databinding.library.baseAdapters.BR;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import thoughtnote.com.R;
import thoughtnote.com.databinding.ActivityDrawerBinding;
import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.utilz.SharedPrefence;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class DrawerAct extends BaseActivity<ActivityDrawerBinding, DrawerViewModel>
        implements NavigationView.OnNavigationItemSelectedListener, DrawerNavigator, HasAndroidInjector {
    private static final String TAG = "DrawerAct";
    @Inject
    DrawerViewModel drawerViewModel;
    @Inject
    SharedPrefence sharedPrefence;
    @Inject
    DispatchingAndroidInjector<Object> fragmentDispatchingAndroidInjector;
    FragmentManager fragmentManager;
    private DrawerLayout mDrawer;

    private NavigationView mNavigationView;

    ActivityDrawerBinding activityDrawerBinding;

    /**
     * Registers {@link BroadcastReceiver}s
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDrawerBinding = getViewDataBinding();
        drawerViewModel.setNavigator(this);
        fragmentManager = getSupportFragmentManager();
        setUp();
    }


    @Override
    public DrawerViewModel getViewModel() {
        return drawerViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_drawer;
    }

    @Override
    public SharedPrefence getSharedPrefence() {
        return sharedPrefence;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_drawer_drawer, menu);
        return false;
    }

    /**
     * Initializes {@link DrawerLayout}
     **/
    private void setUp() {
        mDrawer = activityDrawerBinding.drawerLayout;
        mappBarlayout = activityDrawerBinding.drawerToolbar.appBarLayout;
        mToolbar = activityDrawerBinding.drawerToolbar.toolbar;
        mNavigationView = activityDrawerBinding.navView;
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        getGCMDeviceToken();
    }

    /**
     * Callback when a {@link MenuItem} is clicked
     *
     * @param item {@link MenuItem}
     **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return false;
//        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Callback for {@link MenuItem} click in {@link DrawerLayout} menus
     **/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void lockDrawer() {
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    /**
     * Call this method to lock unlock the drawer
     **/
    public void unlockDrawer() {
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    /**
     * Called when logout is clicked
     **/
    @Override
    public void logout() {

    }

    /**
     * Callback function to receive results from previous pages
     *
     * @param requestCode Id of the request
     * @param resultCode  Id of the result
     * @param data        {@link Intent} with data from previous pages
     **/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public AndroidInjector<Object> androidInjector() {
        return fragmentDispatchingAndroidInjector;
    }

}
