package hack.sport.sporthealthandroidapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hack.sport.sporthealthandroidapp.models.UserDetailsModel;

public class MissionInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MissionInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission_info);

        Button start = (Button) findViewById(R.id.letsStartGoal);
        start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Clicked on view - " + v.getId());

        switch (v.getId()) {
            case R.id.letsStartGoal:
                checkAndStartIntent("cycling");
                break;
        }
    }

    private void checkAndStartIntent(String type) {
        EditText goal = (EditText) findViewById(R.id.missionGoalCount);
        EditText days = (EditText) findViewById(R.id.missionDays);

        Integer goalCount, daysCount;
        if (!goal.getText().toString().equals("")) {
            goalCount = Integer.parseInt(goal.getText().toString());
        } else {
            Toast.makeText(this, "Please select your goal.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!days.getText().toString().equals("")) {
            daysCount = Integer.parseInt(days.getText().toString());
        } else {
            Toast.makeText(this, "Please select days.", Toast.LENGTH_SHORT).show();
            return;
        }

        String data = "{\"type\": \"" + type + "\",\"goal\": " + goalCount +
                ",\"days\": " + daysCount + " }";
        UserDetailsModel.userData.setGoals(data);

    }
}
