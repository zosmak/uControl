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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
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

public class activity_blinds extends AppCompatActivity {

    private NumberPicker nb;
    private ListView listaEstores;
    private String posicao, idEstore, selected, divisao, descricao, estado;
    private ImageView change;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blinds);

        nb = (NumberPicker) findViewById(R.id.nbBlinds);
        change = (ImageView) findViewById(R.id.changePosicaoEstore);

        // limites para a posicao os estores
        nb.setMaxValue(10);
        nb.setMinValue(0);
        nb.setWrapSelectorWheel(false);

        // listar os estores
        listarEstores();

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBlinds();
            }
        });
    }


    public  void  listarEstores()
    {
        try
        {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_estores.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {

                                final ArrayList<String> estores = new ArrayList<>();
                                ArrayAdapter adapterEstores = new ArrayAdapter(activity_blinds.this, android.R.layout.simple_list_item_checked, estores);

                                String descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idEstore = obj.getString("idEstore");
                                    divisao = obj.getString("divisao");
                                    posicao = obj.getString("posicao");
                                    estores.add(descricao);

                                }
                                listaEstores = (ListView)findViewById(R.id.lista_blinds);
                                listaEstores.setAdapter(adapterEstores);

                                // saber qual a descricao
                                listaEstores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        selected = (String) listaEstores.getItemAtPosition(i);
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

    // Atualizar Estores
    public void updateBlinds()
    {
        try
        {
            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/update_estore.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(activity_blinds.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(activity_blinds.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<>();
                    // the POST parameters:
                    params.put("descricao", selected);

                    // ver qual a posicao
                    posicao = String.valueOf(nb.getValue());

                    params.put("posicao", posicao);
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
