package ucontrol.ucontrolstudio;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

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
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_list_item_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        return true;
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
