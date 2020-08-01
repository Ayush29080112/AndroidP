package in.ayush.quickcolorchange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.layout);
        radioGroup = findViewById(R.id.radiogroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case(R.id.btnblue):
                        relativeLayout.setBackgroundColor(Color.parseColor("#74B9FF"));
                        break;
                    case(R.id.btngreen):
                        relativeLayout.setBackgroundColor(Color.parseColor("#6ab04c"));
                        break;
                    case(R.id.btnred):
                        relativeLayout.setBackgroundColor(Color.parseColor("#E83350"));
                        break;
                }
            }
        });
    }
}