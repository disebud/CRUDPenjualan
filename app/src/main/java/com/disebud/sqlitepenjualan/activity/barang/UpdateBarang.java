package com.disebud.sqlitepenjualan.activity.barang;

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
import com.disebud.sqlitepenjualan.activity.pelanggan.Pelanggan;


public class UpdateBarang extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_barang);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_kdBarang_update); // kode
        text2 = (EditText) findViewById(R.id.et_namaBarang_update); // nama
        text3 = (EditText) findViewById(R.id.et_satuan_barang_update); // satuan
        text4 = (EditText) findViewById(R.id.et_harga_barang_update); // harga

        btn1 = (Button) findViewById(R.id.button_save_barang_update);
        btn2 = (Button) findViewById(R.id.button_kembali_barang_update);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM barang WHERE nama_barang = '" +
                getIntent().getStringExtra("namaBarang") + "'" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" UPDATE barang set nama_barang ='" + text2.getText().toString() + "', " +
                        "satuan='" + text3.getText().toString() + "', " + "harga=" + Integer.parseInt(text4.getText().toString()) + " where kd_barang =" + Integer.parseInt(text1.getText().toString()) + " ");
                Toast.makeText(getApplicationContext(), "Berhasil Di Update" ,
                        Toast.LENGTH_LONG).show();
                Barang.br.RefreshList();
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