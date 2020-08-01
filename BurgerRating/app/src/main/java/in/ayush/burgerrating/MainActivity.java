package in.ayush.burgerrating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView);
    }

    public void submit(View view){
        float ratingValue = ratingBar.getRating();
        if(ratingValue < 2){
            textView.setText("Rating Value: "+ ratingValue + " Sorry to hear that... We will try better next time");
        }else if(ratingValue <= 3){
            textView.setText("Rating Value: "+ ratingValue + " We are constantly improving");
        }else if(ratingValue <= 4){
            textView.setText("Rating Value: "+ ratingValue + " Glad to hear that. We will still improve");
        }else{
            textView.setText("Rating Value: "+ ratingValue + " Thanks !!!");
        }
    }
}