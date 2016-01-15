package com.FiveXlenterprises.ui.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.FiveXlenterprises.constant.FragmentTag;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected void loadFragment(int containerId, Fragment fragment, FragmentTag tag) {
        getFragmentManager()
                .beginTransaction()
                .addToBackStack(tag.name())
                .replace(containerId, fragment, tag.name())
                .commit();
    }

}
