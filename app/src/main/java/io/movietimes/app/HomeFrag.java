package io.movietimes.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class HomeFrag extends Fragment {

    private OnMenuActionListener mListener;

    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home_frag, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_action_search) {
            onSearch();
            return true;
        } else if (id == R.id.menu_action_filter) {
            onFilterList();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onSearch() {
        if (mListener != null) {
            mListener.onSearch();
        }
    }

    private void onFilterList() {
        if (mListener != null) {
            mListener.onFilterList();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuActionListener) {
            mListener = (OnMenuActionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnMenuActionListener {
        void onSearch();

        void onFilterList();
    }
}
