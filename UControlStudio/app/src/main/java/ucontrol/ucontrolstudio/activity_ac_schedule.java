package ucontrol.ucontrolstudio;

import android.app.DatePickerDialog;
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

public class activity_ac_schedule extends AppCompatActivity {

    private NumberPicker nb;
    private ImageView start, end;
    private TextView tvstart, tvend;
    private int ano = 1980, mes = 01, dia = 01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_schedule);

        nb = (NumberPicker) findViewById(R.id.nbSchedule);
        start = (ImageView) findViewById(R.id.scheduleStart);
        end = (ImageView) findViewById(R.id.scheduleEnd);
        tvstart = (TextView) findViewById(R.id.start);

        nb.setMaxValue(40);
        nb.setMinValue(1);
        nb.setWrapSelectorWheel(false);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog picker = new DatePickerDialog(
                        activity_ac_schedule.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                tvstart.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        },
                        ano,
                        mes,
                        dia
                );
                picker.show();
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
}
