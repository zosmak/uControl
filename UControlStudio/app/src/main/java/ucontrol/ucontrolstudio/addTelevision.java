package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class addTelevision extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_television);

        Intent intent = new Intent(getApplicationContext(), activity_television.class);
        startActivity(intent);
    }
}
