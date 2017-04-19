package com.demo.hp.reflectandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private TextView mName;
    private TextView mAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (TextView) findViewById(R.id.id_name);
        mAddress = (TextView) findViewById(R.id.id_address);
        /**下面我们通过发射来拿到FanShePresenter里面的private修饰变量和方法*/

        mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNameText();
            }
        });

        mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showgetProsenaddress();
            }
        });


        findViewById(R.id.method).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //一个参数
                PrivateUtil.invoke(new FanShePresenter(MainActivity.this),
                        "withParam1", new Class[] { String.class },
                        new Object[] { "我是参数" });

                //多个参数
//                PrivateUtil.invoke(new FanShePresenter(MainActivity.this),
//                        "withParam2", new Class[] { String.class ,String.class},
//                        new Object[] { "我是参数","小马" });
            }
        });

    }



    /**
     * 我们首先来拿到private修饰的字段name
     */
    public void getNameText() {
        Field f;
        String name = null;
        FanShePresenter mFanShePresenter = new FanShePresenter(this);
        Class temp = mFanShePresenter.getClass();
        try {
            f = temp.getDeclaredField("name");
            f.setAccessible(true);
            name = (String) f.get(mFanShePresenter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
    }

    /**
     * 调用private修饰的方法getProsenaddress()
     */
    public void showgetProsenaddress() {
        Method method = null;
        FanShePresenter mFanShePresenter = new FanShePresenter(this);
        Class temp = mFanShePresenter.getClass();
        try {
            method = temp.getDeclaredMethod("getProsenaddress", null);
            method.setAccessible(true);
            method.invoke(mFanShePresenter, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
