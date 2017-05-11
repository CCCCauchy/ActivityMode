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
public class SingleInstanceActivity extends AppCompatActivity implements View.OnClickListener {

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
        setTitle("SingleInstanceActivity");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_self:
                startActivity(new Intent(SingleInstanceActivity.this, SingleInstanceActivity.class));
                break;
            case R.id.standard:
                startActivity(new Intent(SingleInstanceActivity.this, StandardActivity.class));
                break;
            case R.id.singleTop:
                startActivity(new Intent(SingleInstanceActivity.this, SingleTopActivity.class));
                break;
            case R.id.singleTask:
                startActivity(new Intent(SingleInstanceActivity.this, SingleTaskActivity.class));
                break;
            case R.id.singleInstance:
                startActivity(new Intent(SingleInstanceActivity.this, SingleInstanceActivity.class));
                break;
        }
    }
}
