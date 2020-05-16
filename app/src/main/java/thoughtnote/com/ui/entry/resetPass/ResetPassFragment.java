package thoughtnote.com.ui.entry.resetPass;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import thoughtnote.com.BR;
import thoughtnote.com.R;
import thoughtnote.com.databinding.FragmentResetPassBinding;
import thoughtnote.com.ui.base.BaseActivity;
import thoughtnote.com.ui.base.BaseFragment;
import thoughtnote.com.ui.entry.EntryAct;

import javax.inject.Inject;

/**
 * Created by Mukesh on 07/05/20.
 */

public class ResetPassFragment extends BaseFragment<FragmentResetPassBinding, ResetPassViewModel> implements ResetPassNavigator {
    public static final String TAG = "ResetPassFragment";
    @Inject
    ResetPassViewModel viewModel;
    FragmentResetPassBinding layoutBinding;

    public static ResetPassFragment newInstance() {
        ResetPassFragment fragment = new ResetPassFragment();
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
    public void navigateToForgotPass() {
        ((EntryAct) getBaseActivity()).openForgotPass(false);
    }

    @Override
    public void navigateToChangePassSuccess() {
        ((EntryAct) getBaseActivity()).openResetPassSuccess(false);
    }

    @Override
    public ResetPassViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_reset_pass;
    }

    @Override
    public BaseActivity getAttachedContext() {
        return (BaseActivity) getContext();
    }
}
