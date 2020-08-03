package in.ayush.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "";
    private TextView result,tempHeading,minTempHeading,maxTempHeading,temp_value,minTemp_value,maxTemp_value;
    private EditText city;
    private RequestQueue requestQueue;
    private Button button;
    private ConstraintLayout layout;
    private LinearLayout layoutSub;
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
        result = findViewById(R.id.result);
        button =  findViewById(R.id.button);
        city = findViewById(R.id.city);
        layout = findViewById(R.id.mainLayout);
        layoutSub = findViewById(R.id.subLayout);
        tempHeading = findViewById(R.id.tempheading);
        minTempHeading =  findViewById(R.id.min_temp_heading);
        maxTempHeading = findViewById(R.id.max_temp_heading);
        minTemp_value = findViewById(R.id.minTemp);
        temp_value = findViewById(R.id.temp);
        maxTemp_value = findViewById(R.id.maxTemp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = city.getText().toString();
                String url = BASE_URL+ cityName + API_KEY;
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray =  response.getJSONArray("weather");
                            JSONObject weather = jsonArray.getJSONObject(0);
                            String weatherType = weather.getString("main");
                            JSONObject tempDetails = response.getJSONObject("main");
                            maxTempHeading.setText("Max Temp");
                            minTempHeading.setText("Min Temp");
                            tempHeading.setText("Current Temp");
                            String temp = tempDetails.getString("temp");
                            String min_temp = tempDetails.getString("temp_min");
                            String max_temp = tempDetails.getString("temp_max");
                            temp_value.setText(String.valueOf(df2.format(Double.parseDouble(temp)-273.15)));
                            minTemp_value.setText(String.valueOf(df2.format(Double.parseDouble(min_temp)-273.15)));
                            maxTemp_value.setText(String.valueOf(df2.format(Double.parseDouble(max_temp)-273.15)));
                            result.setText(weatherType);
                            layoutSub.setBackgroundColor(Color.parseColor("#616C6F"));
                            switch(weatherType.toLowerCase()){
                                case "cloud":
                                    layout.setBackgroundResource(R.drawable.haze);
                                    break;
                                case "clouds":
                                    layout.setBackgroundResource(R.drawable.haze);
                                    break;
                                case "haze":
                                    layout.setBackgroundResource(R.drawable.haze);
                                    break;
                                case "thunder":
                                    layout.setBackgroundResource(R.drawable.thunderstorm);
                                    break;
                                case "rain":
                                    layout.setBackgroundResource(R.drawable.rain);
                                    break;
                                case "clear":
                                    layout.setBackgroundResource(R.drawable.clear);
                                    break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Error Occured while retreiving weather",Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}