package com.example.tintash.abc.fragments;

import android.arch.lifecycle.LifecycleFragment;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by Tintash on 12/2/2017.
 */

public class BaseFragment extends LifecycleFragment {

    protected Unbinder unbinder;

   @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

}
