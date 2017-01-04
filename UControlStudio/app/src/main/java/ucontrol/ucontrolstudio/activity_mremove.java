package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import ucontrol.ucontrolstudio.Remove.remove_ac;
import ucontrol.ucontrolstudio.Remove.remove_alarme;
import ucontrol.ucontrolstudio.Remove.remove_audio;
import ucontrol.ucontrolstudio.Remove.remove_estore;
import ucontrol.ucontrolstudio.Remove.remove_iluminacao;
import ucontrol.ucontrolstudio.Remove.remove_tv;

public class activity_mremove extends AppCompatActivity {

    private ImageView audio, ac, tv, illu, blinds, alarm, doors, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mremove);

        ac =(ImageView)findViewById(R.id.removeMainAc);
        audio = (ImageView)findViewById(R.id.removeMainAudio);
        tv = (ImageView)findViewById(R.id.removeMainTv);
        illu = (ImageView)findViewById(R.id.removeMainIllumination);
        blinds = (ImageView)findViewById(R.id.removeMainBlinds);
        alarm = (ImageView)findViewById(R.id.removeMainAlarm);
        doors = (ImageView)findViewById(R.id.removeMainDoors);
        division = (ImageView)findViewById(R.id.removeMainDivision);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_ac.class);
                startActivity(intent);
            }
        });

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_audio.class);
                startActivity(intent);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_tv.class);
                startActivity(intent);
            }
        });

        illu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_iluminacao.class);
                startActivity(intent);
            }
        });

        blinds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_estore.class);
                startActivity(intent);
            }
        });

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_alarme.class);
                startActivity(intent);
            }
        });

        doors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_audio.class);
                startActivity(intent);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_audio.class);
                startActivity(intent);
            }
        });
    }
}
