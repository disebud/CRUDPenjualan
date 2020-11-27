package com.disebud.sqlitepenjualan.activity.penjualan;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.disebud.sqlitepenjualan.DataHelper;
import com.disebud.sqlitepenjualan.R;

public class LihatPenjualan extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btnKembali;
    EditText ned1, ned2, ned3, ned4,ned5;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_penjual);
        dbHelper = new DataHelper(this);

        ned1 = (EditText) findViewById(R.id.et_kdPenjualan_lihat);
        ned2 = (EditText) findViewById(R.id.et_tgl_penjualan_lihat);
        ned3 = (EditText) findViewById(R.id.et_kdPelanggan_penjulaan_lihat);
        ned4 = (EditText) findViewById(R.id.et_kdBarang_penjualan_lihat);
        ned5 = (EditText) findViewById(R.id.et_qty_penjualan_lihat);

        tv1 = (TextView) findViewById(R.id.tv_nama_pelanggan);
        tv2 = (TextView) findViewById(R.id.tv_nama_barang);

        btnKembali = (Button) findViewById(R.id.button_kembali_penjualan_lihat);


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT id_penjualan,tgl_penjualan,penjualan.kd_pelanggan,pelanggan.nama_pelanggan,penjualan.kd_barang,barang.nama_barang,qty " +
                "FROM penjualan LEFT JOIN pelanggan ON penjualan.kd_pelanggan = pelanggan.kd_pelanggan LEFT JOIN barang ON penjualan.kd_barang=barang.kd_barang " +
                "WHERE id_penjualan ="+ Integer.parseInt(getIntent().getStringExtra("idPenjualan")) +"",null);
//        cursor = db.rawQuery("SELECT * FROM barang WHERE nama_barang = '" +
//                getIntent().getStringExtra("namaBarang") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            ned1.setText(cursor.getString(0).toString());
            ned2.setText(cursor.getString(1).toString());
            ned3.setText(cursor.getString(2).toString());
            tv1.setText(cursor.getString(3).toString());
            ned4.setText(cursor.getString(4).toString());
            tv2.setText(cursor.getString(5).toString());
            ned5.setText(cursor.getString(6).toString());
        }

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

}