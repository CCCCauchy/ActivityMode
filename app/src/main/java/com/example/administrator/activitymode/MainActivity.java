package com.example.administrator.activitymode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * android采用Task来管理多个Activity，当我们启动一个应用时，Android就会为之创建一个Task，
 * 然后启动这个应用入口Activity。Android并没有为Task提供API，只能调用Activity的getTaskId()方法来获取它所在的Task的ID。
 * 其实我们可以把Task理解成Activity栈，Task以栈的形式来管理Activity：先启动的Activity被放在Task栈底，
 * 后启动的Activity被放在Task栈顶
 *
 Activity的加载模式，就负责管理实例化、加载Activity的方式、并可以控制Activity与Task之间的加载关系
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button standard;
    private Button singleTop;
    private Button singleTask;
    private Button singleInstance;
    private Button dial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        standard = (Button) findViewById(R.id.standard);
        singleTop = (Button) findViewById(R.id.singleTop);
        singleTask = (Button) findViewById(R.id.singleTask);
        singleInstance = (Button) findViewById(R.id.singleInstance);
        dial = (Button) findViewById(R.id.dial);
        standard.setOnClickListener(this);
        singleTop.setOnClickListener(this);
        singleTask.setOnClickListener(this);
        singleInstance.setOnClickListener(this);
        dial.setOnClickListener(this);

        dial.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.standard:
//                每次通过这种模式来启动目标Activity时，Android总会为目标Activity创建一个新的实例，
//                并将该Activity添加到当前Task栈中——这种模式不会启动新的Task，新的Activity将被添加到原有的Task中
                startActivity(new Intent(MainActivity.this, StandardActivity.class));
                break;
            case R.id.singleTop:
//                当将要启动的Activity已经位于Task栈顶时，系统不会重新创建目标Activity实例，
//                而是直接复用已有的Activity实例。其他与standard模式基本相似
                startActivity(new Intent(MainActivity.this, SingleTopActivity.class));
                break;
            case R.id.singleTask:
//                采用这种加载模式的Activity在同一个Task内只有一个实例，当系统采用singleTask模式启动目标Activity时，可分为如下三种情况：
//                i. 如果将要启动的Activity不存在，系统将会创建目标Activity的实例，并将它加入Task栈顶

//                ii. 如果将要启动的Activity已经位于Task栈顶，此时与singleTop模式的行为相同

//                iii. 如果将要启动的Activity已经存在但是没有位于Task栈顶，系统将会把位于该Activity上面的
//                所有Activity移除Task栈，从而使得目标Activity转入栈顶
                startActivity(new Intent(MainActivity.this, SingleTaskActivity.class));
                break;
            case R.id.singleInstance:
//                这种加载模式下，系统保证无论从哪个Task中启动目标Activity，只会创建一个目标Activity实例，并会 使用
//                一个全新的Task栈来装载该Activity实例。当系统采用singleInstance模式启动目标Activity时，可以分为下面两种情况：

//                i.如果将要启动的目标Activity不存在，系统会先创建一个全新的Task、再创建目标Activity实例，并会将它加入新的Task栈顶
//                ii.如果将要启动的目标Activity已经存在，无论它位于哪个应用程序，无论它位于哪个Task中，
//                系统将会把Activity所在的Task转到前台，从而使该Activity显示出来

//                注意：采用singleInstance模式加载Activity总是位于Task栈顶，采用singleInstance模式
//                    加载Activity所在Task只包含该Activity
                startActivity(new Intent(MainActivity.this, SingleInstanceActivity.class));
                break;
            case R.id.dial:
                //典型singleInstance
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
                break;
        }
    }
}
