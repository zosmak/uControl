package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import ucontrol.ucontrolstudio.Remove.remove_ac;
import ucontrol.ucontrolstudio.Remove.remove_audio;

public class activity_mremove extends AppCompatActivity {

    private ImageView ac;
    private ImageView audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mremove);

        ac =(ImageView)findViewById(R.id.removeMainAc);
        audio = (ImageView)findViewById(R.id.removeAudio);

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
    }
}
