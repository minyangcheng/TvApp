package com.tuya.tv.my;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.PageRow;

import com.tuya.tv.R;

public class MyMainFragment_PageRow extends BrowseSupportFragment {

    private MyPageRowFragmentFactory mPageRowFragmentFactory;
    private ArrayObjectAdapter mMainAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle(getString(R.string.browse_title));
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(ContextCompat.getColor(getActivity(), R.color.fastlane_background));

        mPageRowFragmentFactory = new MyPageRowFragmentFactory(getActivity());
        getMainFragmentRegistry().registerFragment(PageRow.class, mPageRowFragmentFactory);

        createRows();
    }

    private void createRows() {
        mMainAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        HeaderItem headerItem1 = new HeaderItem(1, "场景");
        PageRow pageRow1 = new PageRow(headerItem1);
        mMainAdapter.add(pageRow1);

        HeaderItem headerItem2 = new HeaderItem(2, "设备");
        PageRow pageRow2 = new PageRow(headerItem2);
        mMainAdapter.add(pageRow2);

        setAdapter(mMainAdapter);
    }

}
