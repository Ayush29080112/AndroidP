package in.ayush.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Video> videos =  new ArrayList<>();
        videos.add(new Video("Android",12));
        videos.add(new Video("Java",10));
        Gson gson = new Gson();
        Student student = new Student("Ayush Bajpai","ayush@xzy.com",2,new Course("Android","Android P course"),videos);
        //Converts Object to json
        String json = gson.toJson(student);
        Log.d("Json ", json);

        Student student1 = gson.fromJson(json,Student.class);
        Log.d("Object Converted",student1.getName()+"  "+ student1.getEmail()+ " "+ student1.getCourseCount() +" "+ student1.getCourse()+" "+student1.getVideos());
    }
}