package in.ayush.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random randomNumber= new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rollDices(View view){

        ImageView imageViewForDice1 = findViewById(R.id.imageView1);
        ImageView imageViewForDice2 = findViewById(R.id.imageView2);

        int numberForDice1 = randomNumber.nextInt(6)+1;
        int numberForDice2 = randomNumber.nextInt(6)+1;

        switch (numberForDice1){
            case 1:
                imageViewForDice1.setImageResource(R.drawable.rdice1);
                break;
            case 2:
                imageViewForDice1.setImageResource(R.drawable.rdice2);
                break;
            case 3:
                imageViewForDice1.setImageResource(R.drawable.rdice3);
                break;
            case 4:
                imageViewForDice1.setImageResource(R.drawable.rdice4);
                break;
            case 5:
                imageViewForDice1.setImageResource(R.drawable.rdice5);
                break;
            case 6:
                imageViewForDice1.setImageResource(R.drawable.rdice6);
                break;

        };

        switch (numberForDice2){
            case 1:
                imageViewForDice2.setImageResource(R.drawable.rdice1);
                break;
            case 2:
                imageViewForDice2.setImageResource(R.drawable.rdice2);
                break;
            case 3:
                imageViewForDice2.setImageResource(R.drawable.rdice3);
                break;
            case 4:
                imageViewForDice2.setImageResource(R.drawable.rdice4);
                break;
            case 5:
                imageViewForDice2.setImageResource(R.drawable.rdice5);
                break;
            case 6:
                imageViewForDice2.setImageResource(R.drawable.rdice6);
                break;

        }
    }
}