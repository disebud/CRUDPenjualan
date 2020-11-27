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

public class UpdatePelanggan extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText text1, text2, text3, text4, text5, text6, text7, text8, text9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pelanggan);
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.et_kdPelanggan_update); // no
        text2 = (EditText) findViewById(R.id.et_namaPelanggan_update); // nama
        text3 = (EditText) findViewById(R.id.et_telp_pelanggan_update); // telp

        btn1 = (Button) findViewById(R.id.button_save_pelanggan_update);
        btn2 = (Button) findViewById(R.id.button_kembali_pelanggan_update);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM pelanggan WHERE nama_pelanggan = '" +
                getIntent().getStringExtra("namaPelanggan") + "'" , null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(" update pelanggan set nama_pelanggan ='" + text2.getText().toString() + "', " +
                        "telp='" + text3.getText().toString() + "' where kd_pelanggan =" + Integer.parseInt(text1.getText().toString()) + " ");
                Toast.makeText(getApplicationContext(), "Berhasil Di Update" ,
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