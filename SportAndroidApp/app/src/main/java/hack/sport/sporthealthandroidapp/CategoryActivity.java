package hack.sport.sporthealthandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import hack.sport.sporthealthandroidapp.adapter.CategoryRecyclerViewAdapter;

/**
 * Created by Abhishek Kumar on 2/27/2016.
 */
public class CategoryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mRecyclerView = (RecyclerView) findViewById(R.id.categoryRecyclerView);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CategoryRecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);
        ((CategoryRecyclerViewAdapter) CategoryActivity.this.mAdapter).setOnItemClickListener(this);
    }

    public void onItemClick(View v) {
        Intent missionIntent = new Intent(this, MissionInfoActivity.class);
        missionIntent.putExtra("mission", "cycling");
        startActivity(missionIntent);
    }
}
