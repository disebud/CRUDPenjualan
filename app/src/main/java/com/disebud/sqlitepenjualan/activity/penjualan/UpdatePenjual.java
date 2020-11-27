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
import com.disebud.sqlitepenjualan.activity.barang.Barang;
import com.disebud.sqlitepenjualan.activity.pelanggan.Pelanggan;


public class UpdatePenjual extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_penjual);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_kdPenjualan_update); // no
        text2 = (EditText) findViewById(R.id.et_tgl_penjualan_update); // nama
        text3 = (EditText) findViewById(R.id.et_kdPelanggan_penjulaan_update); // telp
        text4 = (EditText) findViewById(R.id.et_kdBarang_penjualan_update); // telp
        text5 = (EditText) findViewById(R.id.et_qty_penjualan_update); // telp

        btn1 = (Button) findViewById(R.id.button_save_penjualan_update);
        btn2 = (Button) findViewById(R.id.button_kembali_penjualan_update);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM penjualan WHERE id_penjualan = " +
                Integer.parseInt(getIntent().getStringExtra("idPenjualan")) + "" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" UPDATE penjualan set tgl_penjualan ='" + text2.getText().toString() + "', " +
                        "kd_pelanggan=" + Integer.parseInt(text3.getText().toString() )+ ", " +
                        "kd_barang=" + Integer.parseInt(text4.getText().toString() )+ ", " +
                        "qty=" + Integer.parseInt(text5.getText().toString()) + " where id_penjualan =" + Integer.parseInt(text1.getText().toString()) + " ");
                Toast.makeText(getApplicationContext(), "Berhasil Di Update" ,
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