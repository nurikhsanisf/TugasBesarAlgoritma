package com.example.tugasbesaralgonur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rengwuxian.materialedittext.MaterialEditText;

public class CreateFormActivity extends AppCompatActivity {
    private String jenisKelamin;
    private RadioButton rbJenisKelamin;
    private MaterialEditText etNama;
    private MaterialEditText etAlamat;
    private TextView tvJenisKelamin;
    private TextView tvStatusWarga;
    private TextView tvDusun;
    private RadioGroup rgJenisKelamin;
    private RadioGroup rgStatusWarga;
    private RadioGroup rgDusun;
    private RadioButton rbLakilaki;
    private RadioButton rbPerempuan;
    private RadioButton rbPositif;
    private RadioButton rbPDP;
    private RadioButton rbODP;
    private RadioButton rbODR;
    private RadioButton rbOTG;
    private RadioButton rbKalapanunggal;
    private RadioButton rbGendereh;
    private RadioButton rbStatusWarga;
    private RadioButton rbDusun;
    private MaterialEditText etNik;
    private Button btnSubmit;

    private String textNik;
    private String textNama;
    private String textJenisKelamin;
    private String textStatusWarga;
    private String textDusun;
    private String textAlamat;
    DataHelper SQLLite = new DataHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createform);

        etNama              = findViewById(R.id.input_nama);
        etAlamat            = findViewById(R.id.input_alamat);
        tvJenisKelamin      = findViewById(R.id.tv_jenis_kelamin);
        tvStatusWarga       = findViewById(R.id.tv_Status_Warga);
        tvDusun             = findViewById(R.id.tv_Dusun);
        rgJenisKelamin      = findViewById(R.id.radioGroupNb);
        rgStatusWarga       = findViewById(R.id.radioGroupSB);
        rgDusun             = findViewById(R.id.radioGroupNR);
        rbLakilaki          = findViewById(R.id.laki_laki);
        rbPerempuan         = findViewById(R.id.radioPerempuan);
        rbPositif           = findViewById(R.id.radioPositif);
        rbPDP               = findViewById(R.id.PDP);
        rbODP               = findViewById(R.id.ODP);
        rbODR               = findViewById(R.id.ODR);
        rbOTG               = findViewById(R.id.OTG);
        rbKalapanunggal     = findViewById(R.id.Kalapanunggal);
        rbGendereh          = findViewById(R.id.radioGendereh);
        etNik               = findViewById(R.id.input_nik);
        btnSubmit           = findViewById(R.id.simpan_button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textNik     = etNik.getText().toString();
                textNama    = etNama.getText().toString();
                textAlamat  = etAlamat.getText().toString();

                //radio button jenis kelamin
                int selectedIdJenisKelamin  = rgJenisKelamin.getCheckedRadioButtonId();
                rbJenisKelamin              = (RadioButton) findViewById(selectedIdJenisKelamin);
                textJenisKelamin            = rbJenisKelamin.getText().toString();

                //radio button status warga
                int selectedIdStatusWarga   = rgStatusWarga.getCheckedRadioButtonId();
                rbStatusWarga               = (RadioButton) findViewById(selectedIdStatusWarga);
                textStatusWarga             = rbStatusWarga.getText().toString();

                //radio button dusun
                int selectedIdDusun         = rgDusun.getCheckedRadioButtonId();
                rbDusun                     = (RadioButton) findViewById(selectedIdDusun);
                textDusun                   = rbDusun.getText().toString();

                if (textNik == null || textNama == null || textJenisKelamin == null || textAlamat == null || textDusun == null || textStatusWarga == null){
                    Toast.makeText(getBaseContext(),
                        "Pastikan kamu mengisi semua form ",
                        Toast.LENGTH_SHORT).show();
                }else{
                    SQLLite.insert(textNik, textNama, textJenisKelamin, textAlamat, textDusun, textStatusWarga);
                    finish();
                }

                Intent intent = new Intent(CreateFormActivity.this, MainActivity.class);
                startActivity(intent);

                System.out.println("NIK :" + textNik+" , Nama :" + textNama + " , Jenis Kelamin :" + textJenisKelamin +" , Alamat :"+ textAlamat + " , Dusun :" + textDusun + " , Status Warga" + textStatusWarga);
//                //menampilkan pesan teks / toast
//                Toast.makeText(getBaseContext(),
//                        "Kamu Memilih Notebook " + rbJenisKelamin.getText(),
//                        Toast.LENGTH_SHORT).show();

            }
        });
    }

//    public void radioJenisKelamin(View view){
//        Boolean checked = ((RadioButton) view).isChecked();
//
//        switch (view.getId()) {
//            case R.id.laki_laki:
//                if (checked)
//                    this.jenisKelamin   = "Laki - laki";
//                break;
//
//            case R.id.radioPerempuan:
//                if (checked)
//                    this.jenisKelamin   = "Perempuan";
//                break;
//        }
//    }
}
