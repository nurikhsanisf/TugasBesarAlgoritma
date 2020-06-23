package com.example.tugasbesaralgonur;

public class DataWarga {
    private String id;
    private String nik;
    private String nama;
    private String jenisKelamin;
    private String alamat;
    private String dusun;
    private String statusWarga;

    public DataWarga (String id, String nik, String nama, String jenisKelamin, String alamat, String dusun, String statusWarga){
        this.id             = id;
        this.nik            = nik;
        this.nama           = nama;
        this.jenisKelamin   = jenisKelamin;
        this.alamat         = alamat;
        this.dusun          = dusun;
        this.statusWarga    = statusWarga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getDusun() {
        return dusun;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getStatusWarga() {
        return statusWarga;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setDusun(String dusun) {
        this.dusun = dusun;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void setStatusWarga(String statusWarga) {
        this.statusWarga = statusWarga;
    }
}
