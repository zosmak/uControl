package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_tv_recordings extends AppCompatActivity {

    private Button tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_recordings);

        tv = (Button)findViewById(R.id.channels_recordings);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_television.class);
                startActivity(intent);
            }
        });
    }
}
