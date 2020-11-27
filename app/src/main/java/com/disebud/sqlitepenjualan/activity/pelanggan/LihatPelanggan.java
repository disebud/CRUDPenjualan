package com.disebud.sqlitepenjualan.activity.pelanggan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.disebud.sqlitepenjualan.DataHelper;
import com.disebud.sqlitepenjualan.R;


public class LihatPelanggan extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnKembali;
    EditText ned1, ned2, ned3, ned4, ned5, ned6, ned7, ned8, ned9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pelanggan);
        dbHelper = new DataHelper(this);

        ned1 = (EditText) findViewById(R.id.et_kdPelanggan_lihat);
        ned2 = (EditText) findViewById(R.id.et_namaPelanggan_lihat);
        ned3 = (EditText) findViewById(R.id.et_telp_pelanggan_lihat);

        btnKembali = (Button) findViewById(R.id.button_kembali_pelanggan_lihat);


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pelanggan WHERE nama_pelanggan = '" +
                getIntent().getStringExtra("namaPelanggan") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            ned1.setText(cursor.getString(0).toString());
            ned2.setText(cursor.getString(1).toString());
            ned3.setText(cursor.getString(2).toString());
        }
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

}