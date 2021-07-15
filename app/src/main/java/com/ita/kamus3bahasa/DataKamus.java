package com.ita.kamus3bahasa;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataKamus extends SQLiteOpenHelper{
    private static final String DATABASE_NAME ="dbkamus";
    public static final String INGGRIS ="inggris";
    public static final String INDONESIA ="indonesia";
    public static final String SUNDA ="sunda";
    public DataKamus(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    public void createTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS kamus");
        db.execSQL("CREATE TABLE if not exists kamus(id INTEGER PRIMARY KEY AUTOINCREMENT, inggris TEXT, indonesia TEXT, sunda TEXT);");
    }
    public void generateDAta(SQLiteDatabase db) {
        ContentValues cv=new ContentValues();
        cv.put(INGGRIS, "play");
        cv.put(INDONESIA, "main");
        cv.put(SUNDA, "ulin");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "happy");
        cv.put(INDONESIA, "senang");
        cv.put(SUNDA, "bingah");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "read");
        cv.put(INDONESIA, "membaca");
        cv.put(SUNDA, "maca");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "write");
        cv.put(INDONESIA, "menulis");
        cv.put(SUNDA, "nyerat");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "sleep");
        cv.put(INDONESIA, "tidur");
        cv.put(SUNDA, "kulem");
        db.insert("kamus", INGGRIS, cv);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub }
    }
}