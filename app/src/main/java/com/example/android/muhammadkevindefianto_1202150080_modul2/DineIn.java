package com.example.android.muhammadkevindefianto_1202150080_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

// implement untuk mengimplement spinner pada layout
public class DineIn extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    private Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);
        Intent i = getIntent();
        Toast.makeText(this, i.getStringExtra("toast"), Toast.LENGTH_SHORT).show();
//        mangambil idspinner
        spinner = (Spinner) findViewById(R.id.pilihmeja);
//        mengambil nilaui pada spinner
        if (spinner != null) {spinner.setOnItemSelectedListener(this);}
        // membuat adapter untuk spinner dengan string array label meja
        adapter = ArrayAdapter.createFromResource(this,
                R.array.label_meja, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // menggunakan adapater pada spinner
        if (spinner != null) spinner.setAdapter(adapter);

    }

    public void pesanDine(View view) {
//      membuka menu makan malam
        Intent intent = new Intent(this, MenuMakanMalam.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String mSpinnerLabel = (adapterView.getItemAtPosition(i).toString())+"  Telah Terpilih";
        Toast.makeText(this, mSpinnerLabel, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
