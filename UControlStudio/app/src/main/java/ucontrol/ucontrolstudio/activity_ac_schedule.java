package ucontrol.ucontrolstudio;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

import ucontrol.ucontrolstudio.Add.addAirConditioner;
import ucontrol.ucontrolstudio.Remove.remove_ac;

public class activity_ac_schedule extends AppCompatActivity {

    private NumberPicker nb;
    private ImageView start, end;
    private TextView acstart, acend;
    private int horas=12, minutos=00;
    private ImageView confirm;
    private RadioButton rcold, rregular, rfreeze;
    private String modo, temperatura, idArCondicionado;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_schedule);

        nb = (NumberPicker) findViewById(R.id.nbSchedule);
        start = (ImageView) findViewById(R.id.scheduleStart);
        end = (ImageView) findViewById(R.id.scheduleEnd);
        acstart = (TextView) findViewById(R.id.start);
        acend = (TextView) findViewById(R.id.end);
        confirm = (ImageView)findViewById(R.id.schedule_confirm);
        spinner =(Spinner)findViewById(R.id.spinnerAcSchedule);

        nb.setMaxValue(40);
        nb.setMinValue(1);
        nb.setWrapSelectorWheel(false);

        // ver qual o modo
        if(rcold.isChecked()){
            modo = rcold.getText().toString();
        }
        else if(rregular.isChecked()){
            modo = rregular.getText().toString();
        }
        else if(rfreeze.isChecked()){
            modo = rfreeze.getText().toString();
        }

        // ver qual a temperatura
        temperatura = String.valueOf(nb.getValue());


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

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirAc();
            }
        });
    }

    // listar acs no spinner
    public void spinnerAc() {
        try {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_ar_condicionados.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {
                                final ArrayList<String> acs = new ArrayList<>();
                                ArrayAdapter adapterAc = new ArrayAdapter(activity_ac_schedule.this, android.R.layout.simple_list_item_1, acs);


                                String descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idArCondicionado = obj.getString("idArCondicionado");
                                    acs.add(descricao);
                                }
                                // colocar a informacao na lista
                                spinner = (Spinner) findViewById(R.id.spinnerAcSchedule);
                                spinner.setAdapter(adapterAc);

                                // saber a posição no spinner
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        position++;
                                        idArCondicionado = String.valueOf(position);
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });
            queue.add(jsonRequest);
        } catch (Exception ex) {
        } finally {
        }
    }

    // Inserir nova programacao
    public  void inserirAc()
    {
        try
        {
            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/inserir_ac_schedule.php?horaInicio="+acstart.getText().toString()+"&horaFim="+acend.getText().toString()+"&modo="+modo.toString()+"&intensidade="+temperatura+"idAc"+idArCondicionado;


            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            // Result handling
                            Toast.makeText(activity_ac_schedule.this, "Saved", Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    // Error handling
                    Toast.makeText(activity_ac_schedule.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    error.printStackTrace();
                }
            });
            // Add the request to the queue
            Volley.newRequestQueue(this).add(stringRequest);
        }
        catch(Exception ex)
        {
        }
        finally
        {
        }
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

                        acstart.setText(hourOfDay + ":" + minute);
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

                        acend.setText(hourOfDay + ":" + minute);
                    }
                }, horas, minutos, false);
        timePickerDialog.show();
    }
}
