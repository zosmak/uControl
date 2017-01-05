package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
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

import ucontrol.ucontrolstudio.Remove.remove_ac;

public class activity_air_conditioner extends AppCompatActivity {

    private ImageView ac_schedule;
    private NumberPicker nb;
    private ListView lac;
    private ImageView change;
    private String estado, modo, temperatura, idArCondicionado;
    private RadioButton rcold, rregular, rfreeze;
    private Switch s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_conditioner);

        ac_schedule = (ImageView)findViewById(R.id.ac_schedule);
        nb = (NumberPicker) findViewById(R.id.nbAc);
        change = (ImageView)findViewById(R.id.changeAc);
        rcold = (RadioButton)findViewById(R.id.radioColdAc);
        rregular = (RadioButton)findViewById(R.id.radioRegularAc);
        rfreeze = (RadioButton)findViewById(R.id.radioFreezeAc);
        s = (Switch) findViewById(R.id.ac_switch);

        // ver se está ligado ou não
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked == true){
                    estado = String.valueOf(1);
                }else{
                    estado = String.valueOf(0);
                }

            }
        });

        ac_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_ac_schedule.class);
                startActivity(intent);
            }
        });

        // fazer update
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAc();
            }
        });

        nb.setMaxValue(40);
        nb.setMinValue(1);
        nb.setWrapSelectorWheel(false);



        listarAc();
    }

    // Listar ac
    public  void  listarAc()
    {
        try
        {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_ar_condicionados.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {

                                final ArrayList<String> ac = new ArrayList<>();
                                ArrayAdapter adapterAc = new ArrayAdapter(activity_air_conditioner.this, android.R.layout.simple_list_item_checked, ac);

                                String descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idArCondicionado = obj.getString("idArCondicionado");
                                    temperatura = obj.getString("temperatura");
                                    modo = obj.getString("modo");
                                    estado = obj.getString("estado");
                                    ac.add(descricao);
                                }
                                lac = (ListView)findViewById(R.id.lista_ac);
                                lac.setAdapter(adapterAc);

                                lac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        i++;
                                        idArCondicionado = String.valueOf(i);
                                        //Toast.makeText(activity_air_conditioner.this, idArCondicionado, Toast.LENGTH_SHORT).show();
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
        }
        catch(Exception ex)
        {
        }
        finally
        {
        }

    }

    // Atualizar ac
    public void updateAc()
    {
        try
        {
            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/update_ac.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(activity_air_conditioner.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(activity_air_conditioner.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<>();
                    // the POST parameters:
                    params.put("idArCondicionado", idArCondicionado);

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

                    params.put("modo", modo);
                    params.put("estado", estado.toString());
                    params.put("temperatura", temperatura);
                    return params;
                }
            };
            Volley.newRequestQueue(this).add(postRequest);
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
}
