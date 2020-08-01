package in.ayush.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ExampleViewHolder> {

    private ArrayList<SimpleExampleItem>  simpleExampleItems;

    public CustomAdapter(ArrayList<SimpleExampleItem> simpleExampleItems) {
        this.simpleExampleItems = simpleExampleItems;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public ExampleViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(viewGroup);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        SimpleExampleItem exampleitem  = simpleExampleItems.get(position);
        holder.imageView.setImageResource(exampleitem.getmImageRes());
        holder.textView.setText(exampleitem.getmText());
    }

    @Override
    public int getItemCount() {
        return simpleExampleItems.size();
    }


}
