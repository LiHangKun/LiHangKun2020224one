package com.bawei.lihangkun2020224one.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.lihangkun2020224one.R;
import com.bawei.lihangkun2020224one.base.BaseActivity;

public class Main2Activity extends BaseActivity {


    private TextView tx;

    @Override
    protected void findViewId() {
        tx = findViewById(R.id.tx);
    }

    @Override
    protected void inItData() {
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tx.setText(title+"");
    }

    @Override
    protected int findLayout() {
        return R.layout.activity_main2;
    }
}
