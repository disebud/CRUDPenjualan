package com.disebud.sqlitepenjualan.activity.pelanggan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.disebud.sqlitepenjualan.DataHelper;
import com.disebud.sqlitepenjualan.R;

public class BuatPelanggan extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pelanggan);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_kdPelanggan); // kd
        text2 = (EditText) findViewById(R.id.et_namaPelanggan); // nama
        text3 = (EditText) findViewById(R.id.et_telp_pelanggan); // telp

        btn1 = (Button) findViewById(R.id.button_save_pelanggan);
        btn2 = (Button) findViewById(R.id.button_kembali_pelanggan);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into pelanggan (kd_pelanggan, nama_pelanggan,telp) values(" +
                        Integer.parseInt(text1.getText().toString()) + ",'" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Berhasil Ditambahkan" ,
                        Toast.LENGTH_LONG).show();
                Pelanggan.pl.RefreshList();
                finish();
            }
        } );
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        } );
    }
}