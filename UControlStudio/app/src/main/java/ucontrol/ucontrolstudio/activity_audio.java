package ucontrol.ucontrolstudio;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class activity_audio extends AppCompatActivity {

    private NumberPicker nb;
    private ListView listaDispositivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        nb = (NumberPicker) findViewById(R.id.nbAudio);

        nb.setMaxValue(50);
        nb.setMinValue(0);
        nb.setWrapSelectorWheel(false);
        listarDispositivos();
    }


    public  void  listarDispositivos()
    {
        try
        {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_audios.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {

                                final ArrayList<String> dispositivos = new ArrayList<>();
                                ArrayAdapter adapterDispositivos = new ArrayAdapter(activity_audio.this, android.R.layout.simple_list_item_checked, dispositivos);


                                String res="", idDispositivo, descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    res += "" + dispositivos;
                                    dispositivos.add(descricao);
                                }
                                listaDispositivos = (ListView)findViewById(R.id.lista_dispositivos);
                                listaDispositivos.setAdapter(adapterDispositivos);
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
            //Volley.newRequestQueue(this).add(jsonRequest);
            queue.add(jsonRequest);
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
