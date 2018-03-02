package io.movietimes.app.frag;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import io.movietimes.app.R;
import io.movietimes.app.widget.EmptyView;

public abstract class BaseFrag extends LazyFrag {

    View mContentView;
    EmptyView mEmptyView;

    private OnToolbarActionListener mListener;

    @Override
    public void initView(View view) {
        mEmptyView = new EmptyView(view.getContext());
        ViewGroup viewGroup = (ViewGroup) view;
        mContentView = viewGroup.getChildAt(0);
        viewGroup.addView(mEmptyView);

        setHasOptionsMenu(true);

        if (mListener != null) {
            mListener.onShowToolbar();
        }
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

    public void onBack(String tag) {
        if (mListener != null) {
            mListener.onBack(tag);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnToolbarActionListener) {
            mListener = (OnToolbarActionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnToolbarActionListener {

        void onShowToolbar();

        void onBack(String tag);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_base_toolbar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_action_search) {

            return true;
        } else if (id == R.id.menu_action_filter) {
            return true;
        } else if (id == android.R.id.home) {
            onFragBack();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public abstract void onFragBack();
}
