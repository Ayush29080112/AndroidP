package in.ayush.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    public void screenOne(View view){
        String value = editText.getText().toString();
        if(value.length() == 0){
            editText.setError("No Value");
        }else {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("name",value);
            startActivity(intent);
        }
    }
}