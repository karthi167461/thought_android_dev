package thoughtnote.com.ui.entry.getstarted;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import thoughtnote.com.BR;
import thoughtnote.com.R;
import thoughtnote.com.databinding.FragmentGetstartedBinding;
import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.base.BaseFragment;
import thoughtnote.com.ui.entry.EntryAct;
import thoughtnote.com.utilz.SharedPrefence;

import javax.inject.Inject;

/**
 * Created by Mukesh on 07/05/20.
 */

public class GetStartedFragment extends BaseFragment<FragmentGetstartedBinding, GetStartedViewModel> implements GetStartedNavigator {
    public static final String TAG = "GetStartedFragment";
    @Inject
    GetStartedViewModel viewModel;
    FragmentGetstartedBinding layoutBinding;
    @Inject
    SharedPrefence sharedPrefence;

    public static GetStartedFragment newInstance() {
        GetStartedFragment fragment = new GetStartedFragment();
        Bundle args = new Bundle();
//        args.putParcelable(Constants.IntentExtras.REQUEST_DATA, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        model = getArguments().getParcelable(Constants.IntentExtras.REQUEST_DATA);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutBinding = getViewDataBinding();
        viewModel.setNavigator(this);
    }

    @Override
    public void navigateToLogin() {
        ((EntryAct)getBaseActivity()).openLoginFragment(true);
    }

    @Override
    public void navigateToSignup() {
        ((EntryAct)getBaseActivity()).openSignupFragment(true);
    }

    @Override
    public GetStartedViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_getstarted;
    }


    @Override
    public BaseActivity getAttachedContext() {
        return (BaseActivity) getContext();
    }
}
