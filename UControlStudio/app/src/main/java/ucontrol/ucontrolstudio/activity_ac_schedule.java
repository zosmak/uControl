package ucontrol.ucontrolstudio;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class activity_ac_schedule extends AppCompatActivity {

    private NumberPicker nb;
    private ImageView start, end;
    private TextView tvstart, tvend;
    private int horas=12, minutos=00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_schedule);

        nb = (NumberPicker) findViewById(R.id.nbSchedule);
        start = (ImageView) findViewById(R.id.scheduleStart);
        end = (ImageView) findViewById(R.id.scheduleEnd);
        tvstart = (TextView) findViewById(R.id.start);
        tvend = (TextView) findViewById(R.id.end);

        nb.setMaxValue(40);
        nb.setMinValue(1);
        nb.setWrapSelectorWheel(false);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timepickerStart();
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepickerEnd();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // opções do canto sup. direito
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_tv){
            Intent intent = new Intent(this, activity_television.class);
            this.startActivityForResult(intent, 1);
        }
        else if(id == R.id.action_illumination){
            Intent intent = new Intent(this,activity_illumination.class);
            this.startActivity(intent);
        }
        else if(id == R.id.action_ac) {
            Intent intent = new Intent(this, activity_air_conditioner.class);
            this.startActivity(intent);
        }
        else if(id == R.id.action_audio) {
            Intent intent = new Intent(this, activity_audio.class);
            this.startActivity(intent);
        }
        else if(id == R.id.action_blinds) {
            Intent intent = new Intent(this, activity_blinds.class);
            this.startActivity(intent);
        }
        else if(id == R.id.action_alarm) {
            Intent intent = new Intent(this, activity_alarms.class);
            this.startActivity(intent);
        }
        else if(id == R.id.action_doors) {
            Intent intent = new Intent(this, activity_doors.class);
            this.startActivity(intent);
        }
        else if(id == R.id.action_manage) {
            Intent intent = new Intent(this, activity_manage.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    // time picker start
    public void timepickerStart(){
        // Lançar timepicker
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        tvstart.setText(hourOfDay + ":" + minute);
                    }
                }, horas, minutos, false);
        timePickerDialog.show();
    }

    // time picker end
    public void timepickerEnd(){
        // Lançar timepicker
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        tvend.setText(hourOfDay + ":" + minute);
                    }
                }, horas, minutos, false);
        timePickerDialog.show();
    }
}
