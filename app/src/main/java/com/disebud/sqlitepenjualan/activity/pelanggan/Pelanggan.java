package com.disebud.sqlitepenjualan.activity.pelanggan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.disebud.sqlitepenjualan.DataHelper;
import com.disebud.sqlitepenjualan.R;


public class Pelanggan extends AppCompatActivity {

    public static Pelanggan pl;
    protected Cursor cursor;
    String[] daftar;
    ListView ListView01;
    Button btn;
    Menu menu;
    DataHelper dbcenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelanggan);
        btn=(Button)findViewById(R.id.buttonPelanggan);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent inte = new Intent(Pelanggan.this, BuatPelanggan.class);
                startActivity(inte);
            }
        } );
        pl = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM pelanggan " ,null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView)findViewById(R.id.listViewPelanggan);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = { "Lihat Data" , "Update Data" , "Hapus Data"} ;
                AlertDialog.Builder builder = new AlertDialog.Builder(Pelanggan.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item) {
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), LihatPelanggan.class);
                                i.putExtra("namaPelanggan" , selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdatePelanggan.class);
                                in.putExtra("namaPelanggan" , selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from pasien where nama_pelanggan = '" +selection+ "'");
                                Toast.makeText(getApplicationContext(), "Data "+selection+" Berhasil Dihapus" ,
                                        Toast.LENGTH_LONG).show();
                                RefreshList();
                                break;
                        }
                    }
                } );
                builder.create().show();
            }
        } );
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}

