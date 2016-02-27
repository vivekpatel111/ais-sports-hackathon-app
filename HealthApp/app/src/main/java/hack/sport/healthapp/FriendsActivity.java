package hack.sport.healthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.Arrays;

public class FriendsActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(), ">>>>>>>>" + query,
                        Toast.LENGTH_SHORT).show();
                if(!TextUtils.isEmpty(query))
                {
                    findUserByUserId(query);
                }
                else
                {
                    Toast.makeText(FriendsActivity.this, "No user found in your network.", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(), newText,
                        Toast.LENGTH_SHORT).show();
                findUserByUserId(newText);
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

        }
    }

    private void findUserByUserId(final String username) {
        String imageUrl = "http://blogdailyherald.com/wp-content/uploads/2014/10/wallpaper-for-facebook-profile-photo.jpg";
        final CustomList customList = new CustomList(this, username, imageUrl);
        list=(ListView)findViewById(R.id.friends);
        list.setAdapter(customList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(
                    FriendsActivity.this,
                    "You have added " + CustomList.userName.get(position),
                    Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
