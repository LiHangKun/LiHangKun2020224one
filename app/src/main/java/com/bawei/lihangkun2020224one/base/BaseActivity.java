package com.bawei.lihangkun2020224one.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(findLayout());
        findViewId();
        inItData();
    }

    protected abstract void findViewId();

    protected abstract void inItData();

    protected abstract int findLayout();
}
