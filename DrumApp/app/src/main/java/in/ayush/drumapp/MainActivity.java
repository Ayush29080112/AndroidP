package in.ayush.drumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                m1.start();
//            }
//        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                m2.start();
//            }
//        });
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                m3.start();
//            }
//        });

    }

    public void onClick(View view){
        switch (view.getId()){
            case (R.id.imageButton1):
                m = MediaPlayer.create(this,R.raw.one);
                m.start();
                break;
            case (R.id.imageButton2):
                m = MediaPlayer.create(this,R.raw.two);
                m.start();
                break;
            case (R.id.imageButton3):
                m = MediaPlayer.create(this,R.raw.three);
                m.start();
                break;
            case (R.id.imageButton4):
                m = MediaPlayer.create(this,R.raw.four);
                m.start();
                break;
            case (R.id.imageButton5):
                m = MediaPlayer.create(this,R.raw.fv);
                m.start();
                break;
            case (R.id.imageButton6):
                m = MediaPlayer.create(this,R.raw.sixth);
                m.start();
                break;
            case (R.id.imageButton7):
                m = MediaPlayer.create(this,R.raw.seventh);
                m.start();
                break;
            case (R.id.imageButton8):
                m = MediaPlayer.create(this,R.raw.eighth);
                m.start();
                break;
            case (R.id.imageButton9):
                m = MediaPlayer.create(this,R.raw.one);
                m.start();
                break;
            case (R.id.imageButton10):
                m = MediaPlayer.create(this,R.raw.fv);
                m.start();
                break;
            case (R.id.imageButton11):
                m = MediaPlayer.create(this,R.raw.three);
                m.start();
                break;
            case (R.id.imageButton12):
                m = MediaPlayer.create(this,R.raw.four);
                m.start();
                break;
        }
    }
}