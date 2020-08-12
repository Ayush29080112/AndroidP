package in.ayush.firebaselogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {

    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        userName = findViewById(R.id.user);
        String userNme = getIntent().getStringExtra("userName");
        userName.setText(userNme);
    }

    public void logoff(View view){
        Log.d("Logging Off", "Logging Off");
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Homepage.this,LoginActivity.class);
        startActivity(intent);
    }
}