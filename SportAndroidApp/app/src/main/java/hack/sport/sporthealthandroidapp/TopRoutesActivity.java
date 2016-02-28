package hack.sport.sporthealthandroidapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hack.sport.sporthealthandroidapp.adapter.TopRoutesRecyclerViewAdapter;

/**
 * Created by Abhishek Kumar on 2/27/2016.
 */
public class TopRoutesActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_routes);

        mRecyclerView = (RecyclerView) findViewById(R.id.topRoutesRecyclerView);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new TopRoutesRecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);
       ((TopRoutesRecyclerViewAdapter) TopRoutesActivity.this.mAdapter).setOnItemClickListener(this);
    }

    public void onItemClick(View v) {
    }
}
