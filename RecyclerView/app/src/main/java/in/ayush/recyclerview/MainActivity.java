package in.ayush.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<SimpleExampleItem> exampleItems = new ArrayList<>();
        exampleItems.add(new SimpleExampleItem(R.drawable.node,"Clicked at studio"));
        exampleItems.add(new SimpleExampleItem(R.drawable.oner,"Clicked at Italy"));
        exampleItems.add(new SimpleExampleItem(R.drawable.twor,"Clicked at Rome"));
        exampleItems.add(new SimpleExampleItem(R.drawable.threer,"Clicked at Sydney"));
        exampleItems.add(new SimpleExampleItem(R.drawable.fourr,"Clicked at India"));
        exampleItems.add(new SimpleExampleItem(R.drawable.fiver,"Clicked at America"));
        exampleItems.add(new SimpleExampleItem(R.drawable.sixr,"Clicked at Melbourne"));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager  = new LinearLayoutManager(this);
        adapter = new CustomAdapter(exampleItems);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}