package ucontrol.ucontrolstudio.Add;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ucontrol.ucontrolstudio.R;

public class addTelevision extends AppCompatActivity {

    private EditText descricao;
    private ImageView confirmar;
    private Spinner spinner;
    private String idDivisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_television);

        spinnerDivisoes();

        confirmar = (ImageView) findViewById(R.id.confirmNewAc);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirTv();
            }
        });
    }

    // Inserir nova tv
    public  void inserirTv()
    {
        try
        {
            descricao = (EditText)findViewById(R.id.nameNewTV);

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/inserir_tv.php?descricao="+descricao.getText().toString()+"&divisao="+idDivisao.toString()+"&estado=0&canal=1&gravacao=1&volume=0";


            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            // Result handling
                            Toast.makeText(addTelevision.this, "New television added", Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    // Error handling
                    Toast.makeText(addTelevision.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
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

    public void spinnerDivisoes(){
        try
        {
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            String url = "https://jcc240796.000webhostapp.com/base_dados_uControl/listar_divisoes.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {
                                final ArrayList<String> divisoes = new ArrayList<>();
                                ArrayAdapter adapterDivisoes = new ArrayAdapter(addTelevision.this, android.R.layout.simple_list_item_1, divisoes);


                                String res="", descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    descricao = obj.getString("descricao");
                                    idDivisao = obj.getString("idDivisao");
                                    res += "" + idDivisao;
                                    divisoes.add(descricao);
                                }
                                // colocar a informacao na lista
                                spinner = (Spinner)findViewById(R.id.spinnerDivisionsTV);
                                spinner.setAdapter(adapterDivisoes);
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
}
