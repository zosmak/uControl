package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class addBlinds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blinds);

        Intent intent = new Intent(getApplicationContext(), activity_blinds.class);
        startActivity(intent);
    }
}