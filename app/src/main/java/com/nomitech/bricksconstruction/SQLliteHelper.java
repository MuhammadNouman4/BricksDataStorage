package com.nomitech.bricksconstruction;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLliteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="BricksRecord.db";
    public static final String TABLE_NAME = "BricksData";
    public static final String COL_ID="id";
    public static final String COL_QUANTITY="quantity";
    public static final String COL_QUANTITYPRICE="price";

    public SQLliteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, quantity NUMBER,price NUMBER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean Insert( String  quantity, String  price, String result)
    {
        SQLiteDatabase db= getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COL_QUANTITY, quantity);
        cv.put(COL_QUANTITYPRICE, price);

        long result1 = db.insert(TABLE_NAME, null, cv);
        if (result1 == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }


}
