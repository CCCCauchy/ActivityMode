package com.example.administrator.activitymode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public class SingleTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private Button standard;
    private Button singleTop;
    private Button singleTask;
    private Button singleInstance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        standard = (Button) findViewById(R.id.standard);
        singleTop = (Button) findViewById(R.id.singleTop);
        singleTask = (Button) findViewById(R.id.singleTask);
        singleInstance = (Button) findViewById(R.id.singleInstance);
        standard.setOnClickListener(this);
        singleTop.setOnClickListener(this);
        singleTask.setOnClickListener(this);
        singleInstance.setOnClickListener(this);
        setTitle("SingleTaskActivity");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.standard:
                startActivity(new Intent(SingleTaskActivity.this, StandardActivity.class));
                break;
            case R.id.singleTop:
                startActivity(new Intent(SingleTaskActivity.this, SingleTopActivity.class));
                break;
            case R.id.singleTask:
                startActivity(new Intent(SingleTaskActivity.this, SingleTaskActivity.class));
                break;
            case R.id.singleInstance:
                startActivity(new Intent(SingleTaskActivity.this, SingleInstanceActivity.class));
                break;
        }
    }
}
