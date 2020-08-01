package in.ayush.examtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer m;
    TextView timer,done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m = MediaPlayer.create(this,R.raw.three);

        timer = findViewById(R.id.mnumber);
        done = findViewById(R.id.done);

        new CountDownTimer(100000,1000){
            @Override
            public void onTick(long l) {
                timer.setText(Long.toString(l/1000));
            }

            @Override
            public void onFinish() {
                done.setText("Done");
                m.start();
            }
        }.start();
    }
}