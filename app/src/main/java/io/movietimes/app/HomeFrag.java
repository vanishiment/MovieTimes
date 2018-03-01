package io.movietimes.app;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class HomeFrag extends BaseFrag implements SwipeRefreshLayout.OnRefreshListener {

    private OnMenuActionListener mListener;

    private Context mContext;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView mRecyclerView;
    HomeAdapter mHomeAdapter;

    public HomeFrag() {
        // Required empty public constructor
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setHasOptionsMenu(true);

        mSwipeRefreshLayout = view.findViewById(R.id.base_swipe_refresh_layout);
        mRecyclerView = view.findViewById(R.id.base_recycler_view);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter(mContext);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void loadData() {
        showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showContentView();
                mHomeAdapter.replaceData(Data.genCardList());
            }
        }, 3000);
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

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSwipeRefreshLayout.isRefreshing()){
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 3000);
    }

    public interface OnMenuActionListener {
        void onSearch();

        void onFilterList();
    }
}
