package ucontrol.ucontrolstudio;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ImageView illumination, television, air_conditioner, audio, blinds, alarms, doors, manage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // verificar estado da internet
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected()){
        }
        else{
            AlertaNet();
        }

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
        // Intent para a pag. tv
        television.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_television.class);
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
        // Intent para a pag. ac
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_audio.class);
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

    public void AlertaNet(){
        AlertDialog.Builder aviso = new AlertDialog.Builder(MainActivity.this);
        aviso.setMessage("Warning, to use this application you must be connected to the internet.");
        aviso.setCancelable(true);
        aviso.setTitle("Warning!");

        // ok
        aviso.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = aviso.create();
        alert.show();
    }

}
