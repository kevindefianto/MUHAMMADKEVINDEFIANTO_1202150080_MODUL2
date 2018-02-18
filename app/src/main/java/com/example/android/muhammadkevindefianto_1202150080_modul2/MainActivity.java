package com.example.android.muhammadkevindefianto_1202150080_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mangambil id radio groupo
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void Pesan(View view) {
        Intent intent;
//      mengecek radio radio button yang mana yang dipilih
        int selectedjenis = radioGroup.getCheckedRadioButtonId();
        switch (selectedjenis){
//            apabila dine in akan ke aktiivtas Dine In
            case R.id.dineIn:
                intent = new Intent(this, DineIn.class);
                intent.putExtra("toast", "Jenis Pesanan Dine In");
                startActivity(intent);
                break;
//            sebaliknya apabvila Take away akan ke Aktivitas DIne.
            case R.id.takeAway:
                intent = new Intent(this, TakeAway.class);
                intent.putExtra("toast", "Jenis Pesanan Take Away");
                startActivity(intent);
                break;
        }
    }
}
