package com.example.administrator.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 查询Tele表中所有的数据
                Uri uri = Uri.parse("content://com.example.administrator.databasetest.provider/tele");
                Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        // 遍历Cursor对象，取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String phone = cursor.getString(cursor.getColumnIndex("phone"));
                        String sex = cursor.getString(cursor.getColumnIndex("sex"));
                        Log.d("MainActivity", "Tele name is " + name);
                        Log.d("MainActivity", "Tele phone is " + phone);
                        Log.d("MainActivity", "Tele sex is " + sex);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}
