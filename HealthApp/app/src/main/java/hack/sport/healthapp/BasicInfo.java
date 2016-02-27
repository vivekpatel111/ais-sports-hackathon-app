package hack.sport.healthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import hack.sport.healthapp.models.MetricsModel;
import hack.sport.healthapp.models.UserDetailsModel;

public class BasicInfo extends AppCompatActivity implements View.OnClickListener{

    public static UserDetailsModel userData;
    TextView dob;
    TextView height;
    TextView weight;
    TextView diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);

        userData = new UserDetailsModel();

        dob = (TextView) findViewById(R.id.dob);
        dob.setText(userData.getDOB());

        height = (TextView) findViewById(R.id.height);
        height.setText(new Double(userData.getHeight().getMetricValue()).toString());

        weight = (TextView) findViewById(R.id.weight);
        weight.setText(new Double(userData.getWeight().getMetricValue()).toString());

        diseases = (TextView) findViewById(R.id.diseasesList);
        diseases.setText(userData.getDiseases().toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.nextButton:
                nextButtonClicked();
                break;
        }
    }

    private void nextButtonClicked()
    {
        if(!TextUtils.isEmpty(dob.getText()))
        {
            userData.setDOB(dob.getText().toString());
        }
        else
        {
            Toast.makeText(this, "Please select date of birth.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!TextUtils.isEmpty(weight.getText()))
        {
            userData.setWeight(new MetricsModel("kg", Double.parseDouble(weight.getText().toString()), "float"));
        }
        else
        {
            Toast.makeText(this, "Please select weight.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!TextUtils.isEmpty(height.getText()))
        {
            userData.setHeight(new MetricsModel("cm", Double.parseDouble(height.getText().toString()), "float"));
        }
        else
        {
            Toast.makeText(this, "Please select height.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!TextUtils.isEmpty(diseases.getText()))
        {
            userData.setDiseases(new ArrayList<>(Arrays.asList(diseases.getText().toString().split(","))));
        }

        startActivity(new Intent(this, GoalsActivity.class));
    }
}
