package thoughtnote.com.ui.entry.resetPassSuccess;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import thoughtnote.com.BR;
import thoughtnote.com.R;
import thoughtnote.com.databinding.FragmentResetPassSuccessBinding;
import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.base.BaseFragment;
import thoughtnote.com.ui.entry.EntryAct;

/**
 * Created by Mukesh on 16/05/20.
 */

public class ResetPassSuccessFragment extends BaseFragment<FragmentResetPassSuccessBinding, ResetPassSuccessViewModel> implements ResetPassSuccessNavigator {
    public static final String TAG = "ResetPassSuccessFragment";
    @Inject
    ResetPassSuccessViewModel viewModel;
    FragmentResetPassSuccessBinding layoutBinding;

    public static ResetPassSuccessFragment newInstance() {
        ResetPassSuccessFragment fragment = new ResetPassSuccessFragment();
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
        ((EntryAct) getBaseActivity()).openLoginFragment(true);
    }

    @Override
    public ResetPassSuccessViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_reset_pass_success;
    }

    @Override
    public BaseActivity getAttachedContext() {
        return (BaseActivity) getContext();
    }
}
