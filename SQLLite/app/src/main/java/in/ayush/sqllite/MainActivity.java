package in.ayush.sqllite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText editTextId,editTextName,editTextEmail,editTextCC;
    Button buttonAdd, buttonGetData,buttonUpdate, buttonDelete, buttonViewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        editTextId = findViewById(R.id.editText_id);
        editTextName = findViewById(R.id.editText_name);
        editTextEmail = findViewById(R.id.editText_email);
        editTextCC = findViewById(R.id.editText_CC);

        buttonAdd = findViewById(R.id.button_add);
        buttonGetData = findViewById(R.id.button_view);
        buttonUpdate = findViewById(R.id.button_update);
        buttonDelete = findViewById(R.id.button_delete);
        buttonViewAll = findViewById(R.id.button_viewAll);
        addData();
        getData();
        getAllData();
        updateData();
        deleteData();
    }

    public void deleteData(){
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteData(editTextId.getText().toString());
                Toast.makeText(MainActivity.this,"Deleted Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public  void updateData(){
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean updated = dbHelper.updateData(editTextId.getText().toString(),editTextName.getText().toString(),editTextEmail.getText().toString(),editTextCC.getText().toString());
                if(updated){
                    Toast.makeText(MainActivity.this,"Updated Successfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Issue occurred while updating Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getData(){
        buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                if(id.equals(String.valueOf(""))){
                    editTextId.setError("Please enter the Id");
                    return;
                }
                Cursor cursor = dbHelper.getData(id);
                String data = null;
                if(cursor.moveToNext()){
                    data = "Id: "+cursor.getString(0)+"\n"+
                            "Name: "+cursor.getString(1)+"\n"+
                            "Email: "+cursor.getString(2)+"\n"+
                            "Course  Count: "+cursor.getString(3)+"\n";
                    showMessage("Data  is",data);
                }
            }
        });
    }

    public void addData(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inserted = dbHelper.insertData(editTextName.getText().toString(),editTextEmail.getText().toString(),editTextCC.getText().toString());
                if(inserted){
                    Toast.makeText(MainActivity.this,"Data Inserted!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Something Went Wrong :(",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void getAllData(){
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor  = dbHelper.getAllData();
                if(cursor.getCount()==0){
                    showMessage("No Data","No data Found");
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()){

                    stringBuffer.append("Id: "+cursor.getString(0)+"\n"+
                            "Name: "+cursor.getString(1)+"\n"+
                            "Email: "+cursor.getString(2)+"\n"+
                            "Course  Count: "+cursor.getString(3)+"\n");
                }
                showMessage("All Data",stringBuffer.toString());
            }
        });

    }

    private void showMessage(String title,  String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}