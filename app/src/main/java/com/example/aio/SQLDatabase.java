package com.example.aio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.lang.reflect.Member;

public class SQLDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "MEMBERDATABASE.db";
    private static final String TABLE_NAME = "MEMBER";
    private static final String COLUMN_ID = "Email_Id";
    private static final String COLUMN_PASSWORD = "PASSWORD";

    public SQLDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " VARCHAR(20) PRIMARY KEY," + COLUMN_PASSWORD + " VARCHAR(20))";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void registerMember(AOIMember member){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, member.getEmail_id());
        values.put(COLUMN_PASSWORD, member.getPassword());
        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }

    public AOIMember loginMember(String email,String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { COLUMN_ID, COLUMN_PASSWORD }, COLUMN_ID + " =? AND " + COLUMN_PASSWORD + " =? ",
                new String[] { String.valueOf(email),String.valueOf(password) }, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            AOIMember member = new AOIMember(cursor.getString(0),cursor.getString(1));
            db.close();
            return member;
        }
        db.close();
        return null;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_PASSWORD}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
