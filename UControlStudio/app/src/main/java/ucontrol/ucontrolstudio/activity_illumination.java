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

public class activity_illumination extends AppCompatActivity {

    private NumberPicker nb;
    private ListView listaLuzes;
    private String idIluminacao, descricao, divisao, estado, intensidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illumination);

        nb = (NumberPicker) findViewById(R.id.nbIllumination);
        nb.setMaxValue(10);
        nb.setMinValue(1);
        nb.setWrapSelectorWheel(false);
        listarLuzes();
    }


    public  void  listarLuzes()
    {
        try
        {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_iluminacao.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {

                                final ArrayList<String> iluminacao = new ArrayList<>();
                                ArrayAdapter adapterIluminacao = new ArrayAdapter(activity_illumination.this, android.R.layout.simple_list_item_checked, iluminacao);


                                String res="", idIluminacao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idIluminacao = obj.getString("idIluminacao");
                                    divisao = obj.getString("divisao");
                                    intensidade = obj.getString("intensidade");
                                    estado = obj.getString("estado");
                                    iluminacao.add(descricao);
                                    res += "" + iluminacao;
                                }
                                listaLuzes = (ListView)findViewById(R.id.lista_ilumination);
                                listaLuzes.setAdapter(adapterIluminacao);
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



    // Atualizar Iluminação
    public void updateIllumination()
    {
        try
        {
            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/update_iluminacao.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(activity_illumination.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(activity_illumination.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            error.printStackTrace();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<>();
                    // the POST parameters:
                    params.put("idIluminacao", idIluminacao);

                    // ver qual a temperatura
                    intensidade = String.valueOf(nb.getValue());

                    // ver se está ligado ou não
                    /*s.setChecked(true);
                    s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                            if(isChecked){
                                Toast.makeText(activity_air_conditioner.this, "ON", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(activity_air_conditioner.this, "OFF", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    if (s.isChecked()) {
                        Toast.makeText(activity_air_conditioner.this, "ON", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(activity_air_conditioner.this, "OFF", Toast.LENGTH_SHORT).show();
                    }*/

                    estado = String.valueOf(1);

                    params.put("estado", estado);
                    params.put("intensidade", intensidade);
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
