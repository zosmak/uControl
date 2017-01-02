package ucontrol.ucontrolstudio.Remove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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
import ucontrol.ucontrolstudio.Add.addAlarm;
import ucontrol.ucontrolstudio.R;

public class remove_ac extends AppCompatActivity {

    private ImageView confirmar;
    private Spinner spinner;
    private String idAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_ac);

        spinnerAc();

        confirmar = (ImageView) findViewById(R.id.confirmRemoverAc);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //removerAc();
            }
        });
    }

    // listar acs no spinner
    public void spinnerAc(){
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
                                final ArrayList<String> acs = new ArrayList<>();
                                ArrayAdapter adapterAc= new ArrayAdapter(remove_ac.this, android.R.layout.simple_list_item_1, acs);


                                String res="", descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idAc = obj.getString("idAc");
                                    res += "" + idAc;
                                    acs.add(descricao);
                                }
                                // colocar a informacao na lista
                                spinner = (Spinner)findViewById(R.id.spinnerAcRemove);
                                spinner.setAdapter(adapterAc);
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

    /*public  void  test4()
    {
        // Send data
        try
        {
            tv = (TextView) findViewById(R.id.textView);

            String url = "http://inove.000webhostapp.com/domotica/remover_divisao.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Result handling
                            tv.setText(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<>();
                    // the POST parameters:
                    params.put("id", "5");
                    //params.put("descricao", "garagem");
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
    }*/
}
