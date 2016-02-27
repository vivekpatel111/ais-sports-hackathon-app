package hack.sport.healthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "WelcomeActivity";
    public static String vendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        if(!TextUtils.isEmpty(WelcomeActivity.vendor))
        {
            userLogInSuccessful(WelcomeActivity.vendor);
        }

        Button gButton = (Button) findViewById(R.id.googleplus);
        gButton.setOnClickListener(this);

        Button fButton = (Button) findViewById(R.id.facebook);
        fButton.setOnClickListener(this);

        Button tButton = (Button) findViewById(R.id.twitter);
        tButton.setOnClickListener(this);

        Button lButton = (Button) findViewById(R.id.linkedin);
        lButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Log.d(TAG, "Clicked on view - " + v.getId());
        String vendor = null;

        switch (v.getId())
        {
            case R.id.googleplus:
                vendor = "googleplus";
                break;
            case R.id.facebook:
                vendor = "facebook";
                break;
            case R.id.linkedin:
                vendor = "linkedin";
                break;
            case R.id.twitter:
                vendor = "twitter";
                break;
        }

        if(!TextUtils.isEmpty(vendor))
        {
            userLogInSuccessful(vendor);
        }
    }

    private void userLogInSuccessful(String vendor)
    {
        Log.d(TAG, "Logging in by " + vendor);
        WelcomeActivity.vendor = vendor;
        Intent basicInfoIntent = new Intent(this, ProfileInfoActivity.class);
        basicInfoIntent.putExtra("vendor", vendor);
        startActivity(basicInfoIntent);
    }
}
