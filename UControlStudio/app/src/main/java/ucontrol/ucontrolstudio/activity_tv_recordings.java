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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
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

import ucontrol.ucontrolstudio.Remove.remove_gravacoes;
import ucontrol.ucontrolstudio.Remove.remove_tv;

public class activity_tv_recordings extends AppCompatActivity {

    private Button tv;
    private ListView lr;
    private Spinner spinner;
    private String idTv, canal;
    private ImageView gravar;
    private TextView textView;
    private NumberPicker nb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_recordings);

        spinnerTv();

        tv = (Button)findViewById(R.id.channels_recordings);
        gravar = (ImageView)findViewById(R.id.botaoGravar);
        textView = (TextView)findViewById(R.id.textViewRecordings);
        nb = (NumberPicker) findViewById(R.id.nbTv_recordings);

        nb.setMinValue(1);
        nb.setMaxValue(400);;
        nb.setWrapSelectorWheel(false);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), remove_gravacoes.class);
                startActivity(intent);
            }
        });

        listarGravacoes();

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_television.class);
                startActivity(intent);
            }
        });

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ver qual o canal
                canal = String.valueOf(nb.getValue());
                gravar();
            }
        });



    }

    // Listar gravacoes
    public  void  listarGravacoes()
    {
        try
        {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_gravacoes.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {

                                final ArrayList<String> recordings = new ArrayList<>();
                                ArrayAdapter adapterRecordings= new ArrayAdapter(activity_tv_recordings.this, android.R.layout.simple_list_item_1, recordings);

                                String idGravacao,canalGravacao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    idGravacao = obj.getString("idGravacao");
                                    canalGravacao = obj.getString("canal");
                                    recordings.add("Recording nº"+idGravacao+", Channel nº "+canalGravacao);
                                }
                                lr= (ListView)findViewById(R.id.lista_recordings);
                                lr.setAdapter(adapterRecordings);
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

    // Gravar
    public  void gravar()
    {
        try
        {
            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/inserir_gravacoes.php?canal="+canal.toString()+"&horaInicio=0&horaFim=0&idTv="+idTv;


            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            // Result handling
                            Toast.makeText(activity_tv_recordings.this, "Recorded", Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    // Error handling
                    Toast.makeText(activity_tv_recordings.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
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

        // Ver qual o canal
        canal = String.valueOf(nb.getValue());

    }

    // listar tvs no spinner
    public void spinnerTv() {
        try {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_tvs.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {
                                final ArrayList<String> tvs = new ArrayList<>();
                                ArrayAdapter adapterTvs = new ArrayAdapter(activity_tv_recordings.this, android.R.layout.simple_list_item_1, tvs);


                                String descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idTv = obj.getString("idTv");
                                    tvs.add(descricao);
                                }
                                // colocar a informacao na lista
                                spinner = (Spinner) findViewById(R.id.spinnerTvRecordings);
                                spinner.setAdapter(adapterTvs);

                                // saber a posição no spinner
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        position++;
                                        idTv = String.valueOf(position);
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
