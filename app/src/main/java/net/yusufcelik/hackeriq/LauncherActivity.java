package net.yusufcelik.hackeriq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(1000);
                    sleep(1000);
                    sleep(1000);
                    sleep(1000);
                    sleep(1000);


                } catch (Exception e) {

                } finally {

                    Intent intent = new Intent(LauncherActivity.this,
                            LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
