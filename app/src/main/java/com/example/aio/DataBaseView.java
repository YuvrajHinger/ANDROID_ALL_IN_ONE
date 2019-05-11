package com.example.aio;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class DataBaseView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbview_layout);
        recyclerView = (RecyclerView) findViewById(R.id.rview);
        SQLDatabase db = new SQLDatabase(this);
        Cursor cursor = db.getAllData();
        cursor.moveToFirst();
        int rlen = cursor.getCount();
        int clen = cursor.getColumnCount();
        String ar[] = new String[rlen*clen];
        int i=-1;
        if (cursor.moveToFirst()) {
            do {
                    i++;
                    ar[i] = cursor.getString(0)+"  "+cursor.getString(1);
            } while (cursor.moveToNext());
        }
        mAdapter = new MyAdapter(ar);
        recyclerView.setAdapter(mAdapter);
    }
}
