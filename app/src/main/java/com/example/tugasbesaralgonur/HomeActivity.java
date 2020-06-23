package com.example.tugasbesaralgonur;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView tvPositif;
    private TextView tvPDP;
    private TextView tvODP;
    private TextView tvODR;
    private TextView tvOTG;

    private TextView tvPositifKalapanunggal;
    private TextView tvPDPKalapanunggal;
    private TextView tvODPKalapanunggal;
    private TextView tvODRKalapanunggal;
    private TextView tvOTGKalapanunggal;

    private TextView tvPositifGendereh;
    private TextView tvPDPGendereh;
    private TextView tvODPGendereh;
    private TextView tvODRGendereh;
    private TextView tvOTGGendereh;

    DataHelper SQLLite = new DataHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        
        //data odp
        ArrayList<HashMap<String,String>> jumlahODP = SQLLite.detail("statuswarga", "ODP");

        ArrayList<HashMap<String,String>> jumlahODPGendereh = SQLLite.detaildusun("statuswarga", "ODP", "Gendereh");

        ArrayList<HashMap<String,String>> jumlahODPKalapanunggal = SQLLite.detaildusun("statuswarga", "ODP", "Kalapanunggal");


        //data Positif
        ArrayList<HashMap<String,String>> jumlahPositif = SQLLite.detail("statuswarga", "Positif");

        ArrayList<HashMap<String,String>> jumlahPositifGendereh = SQLLite.detaildusun("statuswarga", "Positif", "Gendereh");

        ArrayList<HashMap<String,String>> jumlahPositifKalapanunggal = SQLLite.detaildusun("statuswarga", "Positif", "Kalapanunggal");


        //data pdp
        ArrayList<HashMap<String,String>> jumlahPDP = SQLLite.detail("statuswarga", "PDP");

        ArrayList<HashMap<String,String>> jumlahPDPGendereh = SQLLite.detaildusun("statuswarga", "PDP", "Gendereh");

        ArrayList<HashMap<String,String>> jumlahPDPKalapanunggal = SQLLite.detaildusun("statuswarga", "PDP", "Kalapanunggal");


        //data odr
        ArrayList<HashMap<String,String>> jumlahODR = SQLLite.detail("statuswarga", "ODR");

        ArrayList<HashMap<String,String>> jumlahODRGendereh = SQLLite.detaildusun("statuswarga", "ODR", "Gendereh");

        ArrayList<HashMap<String,String>> jumlahODRKalapanunggal = SQLLite.detaildusun("statuswarga", "ODR", "Kalapanunggal");


        //data otg
        ArrayList<HashMap<String,String>> jumlahOTG = SQLLite.detail("statuswarga", "OTG");

        ArrayList<HashMap<String,String>> jumlahOTGGendereh = SQLLite.detaildusun("statuswarga", "OTG", "Gendereh");

        ArrayList<HashMap<String,String>> jumlahOTGKalapanunggal = SQLLite.detaildusun("statuswarga", "OTG", "Kalapanunggal");


        tvPositif   = (TextView) findViewById(R.id.tv_orang_positif);
        tvPDP       = (TextView) findViewById(R.id.tv_orang_pdp);
        tvODP       = (TextView) findViewById(R.id.tv_orang_odp);
        tvODR       = (TextView) findViewById(R.id.tv_orang_odr);
        tvOTG       = (TextView) findViewById(R.id.tv_orang_otg);

        tvPositifKalapanunggal   = (TextView) findViewById(R.id.tv_jumlah_positif_1);
        tvPDPKalapanunggal       = (TextView) findViewById(R.id.tv_jumlah_pdp_1);
        tvODPKalapanunggal       = (TextView) findViewById(R.id.tv_jumlah_odp_1);
        tvODRKalapanunggal       = (TextView) findViewById(R.id.tv_jumlah_odr_1);
        tvOTGKalapanunggal       = (TextView) findViewById(R.id.tv_jumlah_otg_1);

        tvPositifGendereh   = (TextView) findViewById(R.id.tv_jumlah_positif_2);
        tvPDPGendereh       = (TextView) findViewById(R.id.tv_jumlah_pdp_2);
        tvODPGendereh       = (TextView) findViewById(R.id.tv_jumlah_odp_2);
        tvODRGendereh       = (TextView) findViewById(R.id.tv_jumlah_odr_2);
        tvOTGGendereh       = (TextView) findViewById(R.id.tv_jumlah_otg_2);

        tvPositif.setText(String.valueOf(jumlahPositif.size()));
        tvODP.setText(String.valueOf(jumlahODP.size()));
        tvPDP.setText(String.valueOf(jumlahPDP.size()));
        tvODR.setText(String.valueOf(jumlahODR.size()));
        tvOTG.setText(String.valueOf(jumlahOTG.size()));

        tvPositifKalapanunggal.setText(String.valueOf(jumlahPositifKalapanunggal.size()));
        tvPDPKalapanunggal.setText(String.valueOf(jumlahPDPKalapanunggal.size()));
        tvODPKalapanunggal.setText(String.valueOf(jumlahODPKalapanunggal.size()));
        tvODRKalapanunggal.setText(String.valueOf(jumlahODRKalapanunggal.size()));
        tvOTGKalapanunggal.setText(String.valueOf(jumlahOTGKalapanunggal.size()));

        tvPositifGendereh.setText(String.valueOf(jumlahPositifGendereh.size()));
        tvPDPGendereh.setText(String.valueOf(jumlahPDPGendereh.size()));
        tvODPGendereh.setText(String.valueOf(jumlahODPGendereh.size()));
        tvODRGendereh.setText(String.valueOf(jumlahODRGendereh.size()));
        tvOTGGendereh.setText(String.valueOf(jumlahOTGGendereh.size()));
    }

}
