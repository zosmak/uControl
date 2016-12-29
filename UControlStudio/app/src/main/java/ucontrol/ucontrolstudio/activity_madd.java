package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class activity_madd extends AppCompatActivity {

    private ImageView adddivison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madd);

        adddivison = (ImageView)findViewById(R.id.addDivison);

        adddivison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addDivision.class);
                startActivity(intent);
            }
        });
    }
}
