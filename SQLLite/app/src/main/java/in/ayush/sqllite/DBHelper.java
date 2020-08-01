package in.ayush.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "mystudent.db";
    public final static String TABLE_NAME = "mystudent_table";
    public final static String COL1 = "ID";
    public final static String COL2 = "NAME";
    public final static String COL3 = "EMAIL";
    public final static String COL4 = "COURSE_COUNT";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME  TEXT, " +
                "EMAIL TEXT, " +
                "COURSE_COUNT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }


    public boolean insertData(String name, String email, String courseCount){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        Log.d("Name  ",name);
        Log.d("Email  ",email);
        Log.d("courseCount  ",courseCount);
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,courseCount);
        long  res  = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if(res  == -1){
            return false;
        }
        return true;
    }

    public boolean updateData(String id,String name, String email, String courseCount){
        SQLiteDatabase  sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,courseCount);
        sqLiteDatabase.update(TABLE_NAME,contentValues,"ID =?",new String[]{id});
        return true;
    }

    public Cursor getData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME + " WHERE ID = '"+id+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[]{id});
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("Select * From "+TABLE_NAME,null);
    }
}
