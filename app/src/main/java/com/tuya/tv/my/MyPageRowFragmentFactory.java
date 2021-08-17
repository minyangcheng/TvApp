package com.tuya.tv.my;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.Row;

public class MyPageRowFragmentFactory extends BrowseSupportFragment.FragmentFactory {

    public MyPageRowFragmentFactory(Activity activity) {

    }

    @Override
    public Fragment createFragment(Object rowObj) {
        Row row = (Row) rowObj;
        L.log("row " + row.getHeaderItem().getId());
        return new MyGridFragment();
    }

}
