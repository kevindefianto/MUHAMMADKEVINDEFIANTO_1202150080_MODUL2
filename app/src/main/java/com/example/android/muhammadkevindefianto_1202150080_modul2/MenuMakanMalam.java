package com.example.android.muhammadkevindefianto_1202150080_modul2;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

public class MenuMakanMalam extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Menu> mMenu;
    private MenuAdapter mAdapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_makan_malam);
//      mangambil id recycler view dari layout
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//      set manjadi linear layout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // membuat array list objekl menu untuk menyimpan String dan image
        mMenu = new ArrayList<>();
//      membuat adapter untuk recycler view
        mAdapter = new MenuAdapter(this, mMenu);

        initializeData();
    }

    @SuppressLint("RestrictedApi")
    private void initializeData() {
        //Get the resources from the XML file
//        mengambil array list string
        String[] menuList = getResources().getStringArray(R.array.menu_nama);
        String[] menuHarga = getResources().getStringArray(R.array.harga);
        String[] menuKomposisi = getResources().getStringArray(R.array.komposisi);
        TypedArray menuImageResources = getResources().obtainTypedArray(R.array.menu_images);
        //Clear the existing data (to avoid duplication)

        mMenu.clear();

        //memasukkan String dan Image id ke Array list Menu objek

        for(int i=0; i<menuList.length; i++){
            mMenu.add(new Menu(menuList[i], menuHarga[i], menuKomposisi[i],
                    menuImageResources.getResourceId(i,0)));
        }
        //Recycle the typed array
        menuImageResources.recycle();

        //notifkasi perubahan pada adapter dan menggunakan adaptr pada recycler view
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
    }

}

