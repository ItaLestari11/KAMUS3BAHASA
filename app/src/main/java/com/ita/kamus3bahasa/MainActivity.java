package com.ita.kamus3bahasa;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private EditText txtInggris;
    private EditText txtIndonesia;
    private EditText txtSunda;
    private DataKamus datakamus = null;
    public static final String INGGRIS = "inggris";
    public static final String INDONESIA = "indonesia";
    public static final String SUNDA = "sunda";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datakamus = new DataKamus(this);
        db = datakamus.getWritableDatabase();
        datakamus.createTable(db);
        datakamus.generateDAta(db);
        setContentView(R.layout.activity_main);
        txtInggris = (EditText) findViewById(R.id.txtInggris);
        txtIndonesia = (EditText) findViewById(R.id.txtIndonesia);
        txtSunda = (EditText) findViewById(R.id.txtSunda);
    }
    public void getTerjemah(View view) {
        String result = "";
        String result2 = "";
        String englishword = txtInggris.getText().toString();
        kamusCursor = db.rawQuery("SELECT ID, INGGRIS, INDONESIA, SUNDA "
                + "FROM kamus where INGGRIS='" + englishword
                + "' ORDER BY INGGRIS", null);
        if (kamusCursor.moveToFirst()) {
            result = kamusCursor.getString(2);
            result2 = kamusCursor.getString(3);
            for (; !kamusCursor.isAfterLast(); kamusCursor.moveToNext()) {
                result = kamusCursor.getString(2);
                result2 = kamusCursor.getString(3);
            }
        }
        if (result.equals("")) {
            result = "Terjemahan Not Found";
            result2 = "Terjemahan Not Found";
        }
        txtIndonesia.setText(result);
        txtSunda.setText(result2);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        kamusCursor.close();
        db.close();
    }
}
