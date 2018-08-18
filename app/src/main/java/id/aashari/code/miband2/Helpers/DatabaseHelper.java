package id.aashari.code.miband2.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Andy on 06.11.2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "luckyLucid";
    public static final String TABLE_NAME= "measurments";
    public static final String ID= "ID";
    public static final String sessionID= "sessionID";
    public static final String heartRate= "heartRate";
    public static final String timeStamp= "timteStamp";
 //   public static final String COL_5= "DATE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null , 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " +TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,sessionID INTEGER , heartRate INTEGER, timeStamp DATE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

//    public Cursor getSum(String dateFrom , String dateTill){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select sum(PRICE) from "+TABLE_NAME +" where " +COL_5 +" between "+"'"+dateFrom+"' and "+"'"+dateTill+"'", null);
//        return res;
//    }

    public boolean insertData(int  sessionID, int heartRate, String timeStamp){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.sessionID, sessionID);
        contentValues.put(DatabaseHelper.heartRate , heartRate);
        contentValues.put(DatabaseHelper.timeStamp , timeStamp);
        long result =  db.insert(TABLE_NAME , null , contentValues);

        if(result == -1 ){
            return false;
        }else{
            return true;
        }
    }

    //    public boolean makeDBAccount(String account){
//        SQLiteDatabase db = this.getWritableDatabase();
//        onCreate(this);
//
//        long result =  db.insert(TABLE_NAME , null , contentValues);
//
//        if(result == -1 ){
//            return false;
//        }else{
//            return true;
//        }
//    }
//    public Cursor getAllData(String dateFrom , String dateTill){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor result = db.rawQuery("select * from "+TABLE_NAME +" where " +COL_5 +" between "+"'"+dateFrom+"' and "+"'"+dateTill+"'", null);
//        return result;
//    }
//    public Cursor getAllData(String dateFrom , String dateTill){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor result = db.rawQuery("select * from "+TABLE_NAME +" where " +COL_5+" = "+"'"+dateFrom+"'", null);
//        return result;
//    }
}
