package com.nomitech.bricksconstruction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="BricksRecord.db";
    public static final String TABLE_NAME = "BricksData";
    public static final String COL_ID="id";
    public static final String COL_NAME="name";
    public static final String COL_PHONE="phone";
    public static final String COL_ADDRESS="address";
    public static final String COL_SALARY="salary";





    public SQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, phone NUMBER, address TEXT ,salary NUMBER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean InsertData(String name, String phone, String address,String salary)
    {
       SQLiteDatabase db= getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COL_NAME, name);
        cv.put(COL_PHONE, phone);
        cv.put(COL_ADDRESS, address);
        cv.put(COL_SALARY, salary);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor ViewAll()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME, null);
        return res;
    }

    public boolean updatedata(String id,String name, String phone, String address, String salary ){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_ID, id);
        cv.put(COL_NAME, name);
        cv.put(COL_ADDRESS, address);
        cv.put(COL_PHONE, phone);
        cv.put(COL_SALARY, salary);


        db.update(TABLE_NAME, cv, "id = ?",new String[]{ id });

        return true;
    }

    public Integer deletedata(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ?",new String[]{ id });

    }
}
