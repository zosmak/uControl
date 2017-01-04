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

public class addDivision extends AppCompatActivity {

    private EditText descricao;
    private ImageView confirmar;
    private String idDivisao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_division);

        confirmar = (ImageView) findViewById(R.id.confirmNewDivison);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirDivisoes();
            }
        });
    }

    // Inserir nova divisão
    public  void inserirDivisoes()
    {
        try
        {
            descricao = (EditText)findViewById(R.id.namedivision);

            String url = "http://jcc240796.000webhostapp.com/base_dados_uControl/inserir_divisao.php?descricao="+descricao.getText().toString();


            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            // Result handling
                            Toast.makeText(addDivision.this, "New division added", Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    // Error handling
                    System.out.println("Something went wrong!");
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
}
