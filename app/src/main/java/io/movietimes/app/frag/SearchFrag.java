package io.movietimes.app.frag;

import android.view.View;

import io.movietimes.app.R;

public class SearchFrag extends BaseFrag {

    public SearchFrag() {
        // Required empty public constructor
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    public void onFragBack() {
        onBack(SearchFrag.class.getSimpleName());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void loadData() {

    }
}
