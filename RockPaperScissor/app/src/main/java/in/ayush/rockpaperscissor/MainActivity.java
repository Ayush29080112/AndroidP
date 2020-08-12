package in.ayush.rockpaperscissor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference rootRef = database.getReference();
    DatabaseReference gameRef = rootRef.child("game");

    TextView textView;
    Button rock,paper,scissor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rootRef.child("users").child("01").child("email").setValue("Sam@cool.com");
        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissor = findViewById(R.id.scissor);
        textView = findViewById(R.id.textView);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameRef.setValue("Rock");
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameRef.setValue("Paper");
            }
        });

        scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameRef.setValue("Scissor");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        gameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (null != dataSnapshot.getValue()) {
                    textView.setText(dataSnapshot.getValue().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this,"Error Occured!!!",Toast.LENGTH_SHORT);
            }
        });

    }
}