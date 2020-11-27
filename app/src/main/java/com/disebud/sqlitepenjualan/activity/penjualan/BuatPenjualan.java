package com.disebud.sqlitepenjualan.activity.penjualan;

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

public class BuatPenjualan extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_penjualan);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_kdPenjualan); // kd
        text2 = (EditText) findViewById(R.id.et_tgl_penjualan); // nama
        text3 = (EditText) findViewById(R.id.et_kdPelanggan_penjulaan); // kd pelanggan
        text4 = (EditText) findViewById(R.id.et_kdBarang_penjualan); // kd barang
        text5 = (EditText) findViewById(R.id.et_qty_penjualan); // qty

        btn1 = (Button) findViewById(R.id.button_save_penjualan);
        btn2 = (Button) findViewById(R.id.button_kembali_penjualan);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into penjualan (id_penjualan, tgl_penjualan, kd_pelanggan, kd_barang,qty) " +
                        "values(" + Integer.parseInt(text1.getText().toString()) + ",'" +
                        text2.getText().toString() + "'," +
                        Integer.parseInt(text3.getText().toString()) + "," +
                        Integer.parseInt(text4.getText().toString()) + "," +
                        Integer.parseInt(text5.getText().toString()) + ")");

                Toast.makeText(getApplicationContext(), "Berhasil Ditambahkan" ,
                        Toast.LENGTH_LONG).show();
                Penjualan.pj.RefreshList();
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