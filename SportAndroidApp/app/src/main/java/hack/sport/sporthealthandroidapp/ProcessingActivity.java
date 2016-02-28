package hack.sport.sporthealthandroidapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ProcessingActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    int progressStatus = 0;
    ProgressBar progressBar;
    Integer time;
    TextView textView;
    static Boolean initDone = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.processing);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        time = intent.getIntExtra("time", 3);

        textView = (TextView) findViewById(R.id.processText);
        textView.setText(message);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        for (long loop = 0; loop < 1000000000; loop++) ;
                    }
                    progressStatus += new Random().nextInt() % 10;

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            if (progressStatus <= 95) {
                                progressBar.setProgress(progressStatus);
                            } else {
                                changeIntent();
                            }
                        }
                    });
                }
            }
        }).start();

        changeIntent();
    }

    private void changeIntent() {
        if(!initDone){
            Intent processingIntent = new Intent(ProcessingActivity.this,
                    ProcessingActivity.class);
            processingIntent.putExtra("message", "Getting nearest routes for you.");
            processingIntent.putExtra("time", 5);
            initDone = true;
            startActivity(processingIntent);
        }else{
            startActivity(new Intent(ProcessingActivity.this, UserHeatGoogleMap.class));
        }
    }
}
