package in.ayush.fireuserlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText userName, email,  name;
    Button button;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference rootref = db.getReference();
    DatabaseReference userRef =  rootref.child("users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.username);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasError = validateField();
                if(!hasError){
                    String myUseName = userName.getText().toString().trim();
                    String myEmail = email.getText().toString().trim();
                    String myName = name.getText().toString().trim();
                    Map<String,String> userMap = new HashMap();
                    userMap.put("UserName",myUseName);
                    userMap.put("Name",myName);
                    userMap.put("Email",myEmail);

                    userRef.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                updateUI();
                            }else{
                                Toast.makeText(MainActivity.this,"Error occurred while adding user",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void updateUI() {
        Intent intent = new Intent(MainActivity.this,UsersList.class);
        startActivity(intent);
    }

    private boolean validateField() {
        boolean hasError = false;
        if(userName.getText() == null||userName.getText().toString().isEmpty()){
            userName.setError("Field cannot be empty");
            hasError = true;
        }
        if(name.getText() == null||name.getText().toString().isEmpty()){
            name.setError("Field cannot be empty");
            hasError = true;
        }
        if(email.getText() == null||email.getText().toString().isEmpty()){
            email.setError("Field cannot be empty");
            hasError = true;
        }
        return  hasError;
    }
}