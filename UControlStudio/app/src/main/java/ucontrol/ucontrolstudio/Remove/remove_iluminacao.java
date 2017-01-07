package ucontrol.ucontrolstudio.Remove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ucontrol.ucontrolstudio.R;

public class remove_iluminacao extends AppCompatActivity {

    private ImageView confirmar;
    private Spinner spinner;
    private String idIluminacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_iluminacao);

        spinnerIluminacao();

        confirmar = (ImageView) findViewById(R.id.confirmRemoverIluminacao);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerIluminacao();
            }
        });

    }

    // listar iluminacao no spinner
    public void spinnerIluminacao() {
        try {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_iluminacao.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {
                                final ArrayList<String> ilu = new ArrayList<>();
                                ArrayAdapter adapterIlu = new ArrayAdapter(remove_iluminacao.this, android.R.layout.simple_list_item_1, ilu);


                                String descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idIluminacao = obj.getString("idIluminacao");
                                    ilu.add(descricao);
                                }
                                // colocar a informacao na lista
                                spinner = (Spinner) findViewById(R.id.spinnerIluminacaoRemove);
                                spinner.setAdapter(adapterIlu);

                                // saber a posição no spinner
                                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        position++;
                                        idIluminacao = String.valueOf(position);
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


    public void removerIluminacao()
    {
        final String selected = spinner.getSelectedItem().toString();
        try
        {
            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/remove_iluminacao.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(remove_iluminacao.this, "Removed successfully", Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(remove_iluminacao.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
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
}
