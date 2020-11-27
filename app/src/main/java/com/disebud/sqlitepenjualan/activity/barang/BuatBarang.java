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

public class BuatBarang extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_barang);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_kdBarang); // kd
        text2 = (EditText) findViewById(R.id.et_namaBarang); // nama
        text3 = (EditText) findViewById(R.id.et_satuan_barang); // satuan
        text4 = (EditText) findViewById(R.id.et_harga_barang); // harga

        btn1 = (Button) findViewById(R.id.button_save_barang);
        btn2 = (Button) findViewById(R.id.button_kembali_barang);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into barang (kd_barang, nama_barang, satuan, harga) values(" +
                        Integer.parseInt(text1.getText().toString()) + ",'" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "'," +
                        Integer.parseInt(text4.getText().toString()) + ")");

                Toast.makeText(getApplicationContext(), "Berhasil Ditambahkan" ,
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