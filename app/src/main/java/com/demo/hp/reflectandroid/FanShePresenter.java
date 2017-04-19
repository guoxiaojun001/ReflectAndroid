package com.demo.hp.reflectandroid;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by HP on 2017/4/19.
 */

public class FanShePresenter {

    private String name;
    public String address;
    public Context mContext;

    public FanShePresenter(Context mContext) {
        this.name = "奥巴马";
        this.address = "美国五角大楼";
        this.mContext = mContext;
    }

    public void getProsenName() {
        Toast.makeText(mContext, "习大大", Toast.LENGTH_SHORT).show();
    }

    private void getProsenaddress() {
        Toast.makeText(mContext, "北京天安门", Toast.LENGTH_SHORT).show();
    }


    private void withParam1(String parm) {
        Toast.makeText(mContext, "接收参数 = " + parm, Toast.LENGTH_SHORT).show();
    }

    private void withParam2(String parm1,String parm2) {
        Toast.makeText(mContext, "接收参数 = " + parm1 + parm2, Toast.LENGTH_SHORT).show();
    }
}
