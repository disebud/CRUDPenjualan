package com.disebud.sqlitepenjualan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbpenjualan.db" ;
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE pelanggan ( kd_pelanggan integer primary key, nama_pelanggan text, telp text )");

        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan, telp) VALUES (1001, 'Dinny Susilowati', '8577110779')");
        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan, telp) VALUES (1002, 'Afif Mahar Widodo', '8988981908')");
        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan, telp) VALUES (1003, 'Didik Setya Budi', '83830082299')");
        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan, telp) VALUES (1004, 'Fahri Saputra', '85156298710')");
        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan, telp) VALUES (1005, 'Galumbang Christo Marbun', '81263816274')");
        db.execSQL("INSERT INTO pelanggan (kd_pelanggan, nama_pelanggan, telp) VALUES (1006, 'Hendika Saputro', '81385745468')");


        db.execSQL("CREATE TABLE barang ( kd_barang integer primary key, nama_barang text, satuan text , harga integer)");

        db.execSQL("INSERT INTO barang (kd_barang, nama_barang, satuan, harga) VALUES (2001, 'Lemari Es Toshiba 2 Pintu', 'Unit', 2700000)");
        db.execSQL("INSERT INTO barang (kd_barang, nama_barang, satuan, harga) VALUES (2002, 'TV Xiomi Android 32 inc', 'Unit', 2000000)");
        db.execSQL("INSERT INTO barang (kd_barang, nama_barang, satuan, harga) VALUES (2003, 'Kabel Antena ', 'Roll', 750000)");

        db.execSQL("CREATE TABLE penjualan ( id_penjualan integer primary key, tgl_penjualan date, kd_pelanggan integer , kd_barang integer, qty integer)");

        db.execSQL("INSERT INTO penjualan (id_penjualan, tgl_penjualan, kd_pelanggan, kd_barang,qty) VALUES (3001, '2020-11-26', 1001, 2001, 1)");
        db.execSQL("INSERT INTO penjualan (id_penjualan, tgl_penjualan, kd_pelanggan, kd_barang,qty) VALUES (3002, '2020-11-26', 1002, 2002, 2)");
        db.execSQL("INSERT INTO penjualan (id_penjualan, tgl_penjualan, kd_pelanggan, kd_barang,qty) VALUES (3003, '2020-11-26', 1003, 2003, 5)");
        db.execSQL("INSERT INTO penjualan (id_penjualan, tgl_penjualan, kd_pelanggan, kd_barang,qty) VALUES (3004, '2020-11-26', 1004, 2004, 2)");
        db.execSQL("INSERT INTO penjualan (id_penjualan, tgl_penjualan, kd_pelanggan, kd_barang,qty) VALUES (3005, '2020-11-26', 1005, 2005, 2)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE pasien");
        db.execSQL("DROP TABLE rekammedis");
        db.execSQL("DROP TABLE dokter");
        onCreate(db);
    }
}
