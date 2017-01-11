package ucontrol.ucontrolstudio.Add;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

public class addDivision extends AppCompatActivity implements SensorEventListener {

    private EditText descricao;
    private ImageView confirmar;
    private String idDivisao;
    private SensorManager mSensorManager;
    private Sensor mSensor;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_division);

        // identificar sensor a utilizar
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_NORMAL);

        confirmar = (ImageView) findViewById(R.id.confirmNewDivison);

        // confirmar nova divisão
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
            String nomeDivision = "" + descricao.getText().toString();
            nomeDivision = nomeDivision.replaceAll(" ", "%20");

            String url = "http://jcc240796.000webhostapp.com/base_dados_uControl/inserir_divisao.php?descricao="+nomeDivision;

            // ver se tem uam descriçao
            if(descricao.getText().toString().equals("")){
                Toast.makeText(addDivision.this, "Insert a name, please!", Toast.LENGTH_SHORT).show();
            }
            else {

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
        }
        catch(Exception ex)
        {
        }
        finally
        {
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if((sensorEvent.values[2] > 13) && flag<=0){
            inserirDivisoes();
            flag++;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
