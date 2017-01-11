package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler SplashScreen1 = new Handler();
        SplashScreen1.postDelayed(splashScreen.this, 3000);
    }

    public void run(){

        startActivity(new Intent(splashScreen.this, MainActivity.class));
        finish();
    }

}
