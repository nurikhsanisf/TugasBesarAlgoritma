package com.example.tugasbesaralgonur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NIK = "nik";
    private static final String COLUMN_NAME = "nama";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_JENISKELAMIN = "jeniskelamin";
    private static final String COLUMN_DUSUN = "dusun";
    private static final String COLUMN_STATUSWARGA = "statuswarga";

    private RecyclerViewAdapter adapter;

    DataHelper SQLLite = new DataHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter
        adapter = new RecyclerViewAdapter(this, getDataWarga());


        // Recycler View
        RecyclerView rvDataWarga    = (RecyclerView) findViewById(R.id.rv_data_warga);
        rvDataWarga.setLayoutManager(new LinearLayoutManager(this));
        rvDataWarga.setAdapter(adapter);

        // Button
        Button btnSumbit    = findViewById(R.id.btn_submit);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateFormActivity.class);
                startActivity(intent);
            }
        });

        Button btnView  = findViewById(R.id.btn_submit_list);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        getAllData();
    }

    private List<DataWarga> getDataWarga() {
        ArrayList<HashMap<String,String>> row = SQLLite.getAllData();
        List<DataWarga> dataWargas  = new ArrayList<DataWarga>();
        for (int i=0; i < row.size(); i++) {
            dataWargas.add(new DataWarga(row.get(i).get(COLUMN_ID),
                    row.get(i).get(COLUMN_NIK),
                    row.get(i).get(COLUMN_NAME),
                    row.get(i).get(COLUMN_JENISKELAMIN),
                    row.get(i).get(COLUMN_ADDRESS),
                    row.get(i).get(COLUMN_DUSUN),
                    row.get(i).get(COLUMN_STATUSWARGA)));
        }

        System.out.println(String.valueOf(dataWargas.size()));
        return dataWargas;
    }

    private void getAllData() {
        ArrayList<HashMap<String,String>> row = SQLLite.getAllData();
        if (row.size() > 0) {
            System.out.println("data ada");
        }else {
            System.out.println("data kosong");
        }
    }
}