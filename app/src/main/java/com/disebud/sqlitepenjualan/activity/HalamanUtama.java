package com.disebud.sqlitepenjualan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.disebud.sqlitepenjualan.R;
import com.disebud.sqlitepenjualan.activity.barang.Barang;
import com.disebud.sqlitepenjualan.activity.barcode.ListScan;
import com.disebud.sqlitepenjualan.activity.pelanggan.Pelanggan;
import com.disebud.sqlitepenjualan.activity.penjualan.Penjualan;

public class HalamanUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
    }

    public void pelangganMove(View view) {
        Intent i =  new Intent(HalamanUtama.this, Pelanggan.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "PELANGGAN PAGE",
                Toast.LENGTH_LONG).show();
    }

    public void barangMove(View view) {
        Intent i = new Intent(HalamanUtama.this, Barang.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "BARANG PAGE",
                Toast.LENGTH_LONG).show();
    }

    public void penjualanMove(View view) {
        Intent i = new Intent(HalamanUtama.this, Penjualan.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "PENJUALAN PAGE",
                Toast.LENGTH_LONG).show();
    }

    public void scanMove(View view) {
        Intent i =  new Intent(HalamanUtama.this, ListScan.class);
        startActivity(i);
        Toast.makeText(getApplicationContext(), "SCAN PAGE",
                Toast.LENGTH_LONG).show();
    }
}