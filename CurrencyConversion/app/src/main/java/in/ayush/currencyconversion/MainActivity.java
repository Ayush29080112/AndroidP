package in.ayush.currencyconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button euro,dollar,yen,dinar,bitcoin,sar,aud,cad,pound;
    EditText rupeeToConvert;
    TextView convertedValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        euro = findViewById(R.id.eurobutton);
        dollar = findViewById(R.id.usDollar);
        yen = findViewById(R.id.yen);
        dinar = findViewById(R.id.dinar);
        bitcoin = findViewById(R.id.bitcoin);
        sar = findViewById(R.id.sar);
        aud = findViewById(R.id.aud);
        cad = findViewById(R.id.cad);
        pound = findViewById(R.id.pound);
        rupeeToConvert = findViewById(R.id.editText);
        convertedValue = findViewById(R.id.textView);
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/85.53f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/74.93f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/.70f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        dinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/243.59f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/687021.80f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        sar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/19.98f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        aud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/50f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/55.21f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });

        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float conValue = Float.parseFloat(rupeeToConvert.getText().toString())/94.21f;
                convertedValue.setText(String.valueOf(conValue));
            }
        });


    }
}