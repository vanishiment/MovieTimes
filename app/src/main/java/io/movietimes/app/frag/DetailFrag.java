package io.movietimes.app.frag;

import android.view.View;

import io.movietimes.app.R;

public class DetailFrag extends BaseFrag {

    public DetailFrag() {
        // Required empty public constructor
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    public void onFragBack() {
        onBack(DetailFrag.class.getSimpleName());
    }

    @Override
    public boolean isHomeFrag() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    public void loadData() {

    }

}
