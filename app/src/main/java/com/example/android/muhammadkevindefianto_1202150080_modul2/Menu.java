package com.example.android.muhammadkevindefianto_1202150080_modul2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

public class Menu {

    private final String namaMenu;
    private final String hargaMenu;
    private final String komposisi;
    private final int imageMenu;


    public Menu(String nama, String hargaMenu, String komposisi,int imageMenu) {
        this.namaMenu = nama;
        this.hargaMenu = hargaMenu;
        this.imageMenu = imageMenu;
        this.komposisi = komposisi;
    }

    String getNama(){
        return namaMenu;
    }
    String getHargaMenu(){
        return hargaMenu;
    }
    String getKomposisi(){return komposisi;}
    int getImageMenu(){ return imageMenu;}

    // method untuk menjalankan aktivitas yang memuncuklkan detail menu.
    static Intent starter(Context context, String namaMenu, String hargaMenu,
                          String komposisi, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailMenu.class);
        detailIntent.putExtra("nama", namaMenu);
        detailIntent.putExtra("harga", hargaMenu);
        detailIntent.putExtra("komposisi", komposisi);
        detailIntent.putExtra("image", imageResId);
        return detailIntent;
    }
}
