package com.dasong.daily.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dason on 2016/12/10 0010.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> list = null ;
    private FragmentManager fm = null ;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fm = fm ;
        this.list = fragmentList ;
    }

    @Override
    public Fragment getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }
}
