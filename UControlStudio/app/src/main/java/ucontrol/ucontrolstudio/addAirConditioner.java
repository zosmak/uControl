package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class addAirConditioner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_air_conditioner);

        Intent intent = new Intent(getApplicationContext(), activity_air_conditioner.class);
        startActivity(intent);
    }
}
