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
        Toast.makeText(mContext, "习大大", Toast.LENGTH_LONG).show();
    }

    private void getProsenaddress() {
        Toast.makeText(mContext, "北京天安门", Toast.LENGTH_LONG).show();
    }

}
