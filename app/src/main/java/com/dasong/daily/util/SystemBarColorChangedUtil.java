package com.dasong.daily.util;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class SystemBarColorChangedUtil {

    /**
     * if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
     //透明状态栏
     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
     //透明导航栏
     getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
     }
     SystemBarTintManager tintManager = new SystemBarTintManager(this);
     // 激活状态栏
     tintManager.setStatusBarTintEnabled(true);
     // enable navigation bar tint 激活导航栏
     tintManager.setNavigationBarTintEnabled(true);
     //设置系统栏设置颜色
     tintManager.setTintColor(R.color.colorPrimary);
     //给状态栏设置颜色
     tintManager.setStatusBarTintResource(R.color.colorPrimary);
     // 设置导航栏设置资源
     tintManager.setNavigationBarTintResource(R.color.colorPrimary);
     */



}
