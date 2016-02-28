package hack.sport.sporthealthandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MissionDecisionActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MissionDecisionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mission_decision);

        Button yes = (Button) findViewById(R.id.yesButton);
        yes.setOnClickListener(this);

        Button no = (Button) findViewById(R.id.noButton);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Clicked on view - " + v.getId());

        switch (v.getId()) {
            case R.id.yesButton:
                Toast.makeText(this, "Please tell us your mission.", Toast.LENGTH_LONG).show();
                changeIntent(true);
                break;

            case R.id.noButton:
                Toast.makeText(this, "Take your time, we will suggest you something.", Toast.LENGTH_SHORT).show();
                changeIntent(true);
                break;
        }
    }

    private void changeIntent(boolean isHavingMission) {
        if (isHavingMission) {
            Intent missionIntent = new Intent(this, CategoryActivity.class);
            startActivity(missionIntent);
        } else {

        }
    }
}
