package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import ucontrol.ucontrolstudio.Add.addAirConditioner;
import ucontrol.ucontrolstudio.Add.addAlarm;
import ucontrol.ucontrolstudio.Add.addDivision;
import ucontrol.ucontrolstudio.Add.addTelevision;

public class activity_madd extends AppCompatActivity {

    private ImageView adddivison, addTv, addAc, addAudio, addIllumination, addBlinds, addDoors, addAlarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madd);

        adddivison = (ImageView)findViewById(R.id.addDivision);
        addTv = (ImageView)findViewById(R.id.addTv);
        addAc = (ImageView)findViewById(R.id.addAC);
        addAudio = (ImageView)findViewById(R.id.addAudio);
        addIllumination = (ImageView)findViewById(R.id.addIlumination);
        addBlinds = (ImageView)findViewById(R.id.addBlinds);
        addDoors = (ImageView)findViewById(R.id.addDoors);
        addAlarms = (ImageView)findViewById(R.id.addAlarms);

        adddivison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addDivision.class);
                startActivity(intent);
            }
        });

        addTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addTelevision.class);
                startActivity(intent);
            }
        });

        addAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addAirConditioner.class);
                startActivity(intent);
            }
        });

        addAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ucontrol.ucontrolstudio.Add.addAudio.class);
                startActivity(intent);
            }
        });

        addIllumination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ucontrol.ucontrolstudio.Add.addIllumination.class);
                startActivity(intent);
            }
        });

        addBlinds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ucontrol.ucontrolstudio.Add.addBlinds.class);
                startActivity(intent);
            }
        });

        addDoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ucontrol.ucontrolstudio.Add.addDoors.class);
                startActivity(intent);
            }
        });

        addAlarms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addAlarm.class);
                startActivity(intent);
            }
        });
    }
}
