package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    private ImageView ilumination;
    private ImageView television;
=======
    private ImageView illumination, television, air_conditioner, audio, blinds, alarms, doors, manage;
>>>>>>> origin/master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        illumination  = (ImageView)findViewById(R.id.main_illumination);
        television  = (ImageView)findViewById(R.id.main_tv);
        air_conditioner  = (ImageView)findViewById(R.id.main_ac);
        audio  = (ImageView)findViewById(R.id.main_audio);
        blinds  = (ImageView)findViewById(R.id.main_blinds);
        alarms  = (ImageView)findViewById(R.id.main_alarm);
        doors  = (ImageView)findViewById(R.id.main_doors);
        manage  = (ImageView)findViewById(R.id.main_manage);

        // Intent para a pag. illumination
        illumination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_illumination.class);
                startActivity(intent);
            }
        });
        // Intent para a pag. ac
        air_conditioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_air_conditioner.class);
                startActivity(intent);
            }
        });
        // Intent para a pag. alarms
        alarms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_alarms.class);
                startActivity(intent);
            }
        });
        // Intent para a pag. blinds
        blinds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_blinds.class);
                startActivity(intent);
            }
        });
        // Intent para a pag. doors
        doors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_doors.class);
                startActivity(intent);
            }
        });
        // Intent para a pag. manage
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_manage.class);
                startActivity(intent);
            }
        });

    }

}
