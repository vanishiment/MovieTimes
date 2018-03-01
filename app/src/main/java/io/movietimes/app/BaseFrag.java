package io.movietimes.app;

import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFrag extends LazyFrag {

    View mContentView;
    EmptyView mEmptyView;

    @Override
    public void initView(View view) {
        mEmptyView = new EmptyView(view.getContext());
        ViewGroup viewGroup = (ViewGroup) view;
        mContentView = viewGroup.getChildAt(0);
        viewGroup.addView(mEmptyView);
    }

    public void showLoading(){
        mContentView.setVisibility(View.GONE);
        if (!mEmptyView.isLoading()){
            mEmptyView.show(true,null,null,null,null);
        }
    }

    public void showTip(String tip){
        mContentView.setVisibility(View.GONE);
        mEmptyView.show(false,tip,null,null,null);
    }

    public void showTipWithDetail(String tip,String detail){
        mContentView.setVisibility(View.GONE);
        mEmptyView.show(false,tip,detail,null,null);
    }

    public void showTipWithButton(String tip,String btnText,View.OnClickListener l){
        mContentView.setVisibility(View.GONE);
        mEmptyView.show(false,tip,null,btnText,l);
    }

    public void showTipWithDetailAndButton(String tip, String detail, String btnText, View.OnClickListener l){
        mContentView.setVisibility(View.GONE);
        mEmptyView.show(false,tip,detail,btnText,l);
    }

    public void showContentView(){
        mContentView.setVisibility(View.VISIBLE);
        mEmptyView.hide();
    }
}
