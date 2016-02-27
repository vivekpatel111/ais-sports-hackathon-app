package hack.sport.healthapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import hack.sport.healthapp.models.MetricsModel;
import hack.sport.healthapp.models.UserDetailsModel;

public class ProfileInfoActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "ProfileInfoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_info);

        fillAvailableData(UserDetailsModel.userData);

        Button profile = (Button) findViewById(R.id.profileButton);
        profile.setOnClickListener(this);

        checkFilledDataAndChangeIntent();
    }

    private void fillAvailableData(UserDetailsModel userData) {
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Clicked on view - " + v.getId());

        switch (v.getId())
        {
            case R.id.profileButton:
                checkFilledDataAndChangeIntent();
                break;
        }
    }

    private void checkFilledDataAndChangeIntent() {
        EditText name = (EditText) findViewById(R.id.name);
        EditText height = (EditText) findViewById(R.id.height);
        EditText weight = (EditText) findViewById(R.id.weight);
        EditText age = (EditText) findViewById(R.id.age);
        EditText location = (EditText) findViewById(R.id.location);

        String nameData, locationData;
        Double heightData, weightData, ageData;
        if(!name.getText().toString().equals(""))
        {
            nameData = name.getText().toString();
        }
        else
        {
            Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!height.getText().toString().equals(""))
        {
            heightData = Double.parseDouble(height.getText().toString());
        }
        else
        {
            Toast.makeText(this, "Please enter your height.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!weight.getText().toString().equals(""))
        {
            weightData = Double.parseDouble(weight.getText().toString());
        }
        else
        {
            Toast.makeText(this, "Please enter your weight.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!age.getText().toString().equals(""))
        {
            ageData = Double.parseDouble(age.getText().toString());
        }
        else
        {
            Toast.makeText(this, "Please enter your age.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!location.getText().toString().equals(""))
        {
            locationData = location.getText().toString();
        }
        else
        {
            Toast.makeText(this, "Please enter your location.", Toast.LENGTH_SHORT).show();
            return;
        }

        UserDetailsModel.userData.setUserName(nameData);
        UserDetailsModel.userData.setWeight(new MetricsModel("kg", weightData, "double"));
        UserDetailsModel.userData.setHeight(new MetricsModel("cm", heightData, "double"));
        UserDetailsModel.userData.setAge(ageData.intValue());
        HashMap<String, String> locationMap = new HashMap<>();
        locationMap.put("user", locationData);
        UserDetailsModel.userData.setLocation(locationMap);

        startActivity(new Intent(this, MissionDecisionActivity.class));
    }
}
