package io.movietimes.app.act;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import io.movietimes.app.R;
import io.movietimes.app.frag.BaseFrag;
import io.movietimes.app.frag.DetailFrag;
import io.movietimes.app.frag.HomeFrag;
import io.movietimes.app.frag.SearchFrag;
import io.movietimes.app.model.Card;
import io.movietimes.app.utils.StatusBarHelper;

public class MainAct extends AppCompatActivity implements HomeFrag.OnMenuActionListener, BaseFrag.OnToolbarActionListener {

    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarHelper.translucent(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        FragmentManager fm = getSupportFragmentManager();
        HomeFrag homeFrag = (HomeFrag) fm.findFragmentByTag(HomeFrag.class.getSimpleName());
        if (homeFrag == null) {
            homeFrag = new HomeFrag();
        }
        fm.beginTransaction().add(R.id.content_frag, homeFrag, HomeFrag.class.getSimpleName())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSearch() {
        FragmentManager fm = getSupportFragmentManager();
        SearchFrag searchFrag = (SearchFrag) fm.findFragmentByTag(SearchFrag.class.getSimpleName());
        if (searchFrag == null) {
            searchFrag = new SearchFrag();
        }
        fm.beginTransaction()
                .replace(R.id.content_frag, searchFrag, SearchFrag.class.getSimpleName())
                .addToBackStack(SearchFrag.class.getSimpleName())
                .commit();
    }

    @Override
    public void onFilterList() {

    }

    @Override
    public void onItemClickListener(View view, Card card, int position) {
        FragmentManager fm = getSupportFragmentManager();
        DetailFrag detailFrag = (DetailFrag) fm.findFragmentByTag(DetailFrag.class.getSimpleName());
        if (detailFrag == null) {
            detailFrag = new DetailFrag();
        }
        fm.beginTransaction()
                .replace(R.id.content_frag, detailFrag, DetailFrag.class.getSimpleName())
                .addToBackStack(DetailFrag.class.getSimpleName())
                .commit();
    }

    @Override
    public void onShowToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setVisibility(View.GONE);

    }

    @Override
    public void onBack(String tag) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setHomeButtonEnabled(false);
        }
        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setVisibility(View.VISIBLE);
        FragmentManager fm = getSupportFragmentManager();
        if (TextUtils.isEmpty(tag)){
            fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }else {
            fm.popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onBack(null);
    }
}
